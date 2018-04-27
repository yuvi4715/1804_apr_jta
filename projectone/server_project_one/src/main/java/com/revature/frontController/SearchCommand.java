package com.revature.frontController;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.eclipse.persistence.jaxb.MarshallerProperties;

import com.revature.db.DatabaseSingletonService;
import com.revature.models.ReinbursementRequest;

public class SearchCommand extends FrontCommand {
	final static Logger log = Logger.getLogger(SearchCommand.class);
	@Override
	public void process() throws ServletException, IOException {
		if (request.getSession(false) == null) {
			response.getWriter().append("{\"status\":\"session ended\"}");
			response.setStatus(417);
			return;
		}
		boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
		if (!isMultipartContent) {
			response.getWriter().println("{\"status\":\"Not multiparse data\"}");
			response.setStatus(417);
			return;
		}
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> fields = upload.parseRequest(request);
			Iterator<FileItem> it = fields.iterator();
			if (!it.hasNext()) {
				log.info("No fields found");
				return;
			}
			String page = null;
			String query = null;
			String approved = null;
			while (it.hasNext()) {
				FileItem fileItem = it.next();
				boolean isFormField = fileItem.isFormField();
				if (isFormField) {
					if (fileItem.getFieldName().equalsIgnoreCase("page"))
						page = fileItem.getString();
					if (fileItem.getFieldName().equalsIgnoreCase("query"))
						query = fileItem.getString();
					if (fileItem.getFieldName().equalsIgnoreCase("getAproved"))
						approved = fileItem.getString();
				}
			}
			try {
				JAXBContext jaxbContext = null;
				jaxbContext = JAXBContext.newInstance(ReinbursementRequest.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				// output pretty printed
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				// Set the Marshaller media type to JSON or XML
				jaxbMarshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");

				// Set it to true if you need to include the JSON root element in the JSON
				// output
				jaxbMarshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);
				// Set it to true if you need the JSON output to formatted
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				String email = (String) request.getSession(false).getAttribute(ProcessLoginPost.USERIDKEY);
				int pageInt = 0;
				try {
					pageInt = Integer.parseInt(page);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				ReinbursementRequest[] result = null;
				if ((Boolean) request.getSession(false).getAttribute(ProcessLoginPost.ISADMINKEY)) {
					if(Boolean.parseBoolean(request.getParameter("getAproved")))
						result = DatabaseSingletonService.getAllRRSearch(pageInt, query);
					else 
						result = DatabaseSingletonService.getAllUnresolvedRRsSearch(pageInt, query);
				} else {
					if(Boolean.parseBoolean(request.getParameter("getAproved")))
						result = DatabaseSingletonService.getAllRRsSearch(pageInt,(String) request.getSession(false).getAttribute(ProcessLoginPost.USERIDKEY), query);
					else 
						result = DatabaseSingletonService.getAllUnresolvedRRsSearch(pageInt, (String) request.getSession(false).getAttribute(ProcessLoginPost.USERIDKEY),query);
				}
				jaxbMarshaller.marshal(result, System.out);
				jaxbMarshaller.marshal(result, response.getWriter());
			} catch (JAXBException e1) {
				e1.printStackTrace();
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}

}
