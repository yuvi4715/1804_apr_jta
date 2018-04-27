package com.revature.frontController;

import java.io.IOException;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
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
import com.revature.models.Employee;
import com.revature.models.Manager;

public class ProcessLoginPost extends FrontCommand {

	final static Logger log = Logger.getLogger(ProcessLoginPost.class);
	private String email;
	private String password;
	private boolean checked;

	public static final String VISITCOUNTKEY = "visitCount";
	public static final String USERIDKEY = "email";
	public static final String ISADMINKEY = "isAdmin";

	@Override
	public void process() throws ServletException, IOException {
		boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
		log.info("isMultipart" + isMultipartContent);
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
			while (it.hasNext()) {
				FileItem fileItem = it.next();
				boolean isFormField = fileItem.isFormField();
				if (isFormField) {
					if (fileItem.getFieldName().equalsIgnoreCase("email"))
						email = fileItem.getString();
					if (fileItem.getFieldName().equalsIgnoreCase("password"))
						password = fileItem.getString();
					if (fileItem.getFieldName().equalsIgnoreCase("checked"))
						checked = Boolean.parseBoolean(fileItem.getString());
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		// TODO
		log.info(email + " " + password + " " + checked);
		Employee e = null;
		Manager m = null;
		if (!checked) {
			e = DatabaseSingletonService.loginEmployee(new Employee("", "", email, false), password);
			log.info(e);
		} else {
			m = DatabaseSingletonService.loginManager(new Manager("", "", email, false), password);
			log.info(m);
		}
		if (e != null || m != null) {
			log.info("Creating session");
			HttpSession session = request.getSession();
			// Get session creation time.
			Date createTime = new Date(session.getCreationTime());

			// Get last access time of this web page.
			Date lastAccessTime = new Date(session.getLastAccessedTime());
			
			
			Integer visitCount = 0;
			String userID = email;
			log.info("Creating session");
			// Check if this is new comer on your web page.
			if (session.isNew()) {
				session.setAttribute(USERIDKEY, userID);
				if (e != null) {
					session.setAttribute(ISADMINKEY, false);
				} else if(m!=null){
					session.setAttribute(ISADMINKEY, true);
				}
			} else {
				visitCount = (Integer) session.getAttribute(VISITCOUNTKEY);
				visitCount = visitCount + 1;
				userID = (String) session.getAttribute(USERIDKEY);
			}
			session.setAttribute(VISITCOUNTKEY, visitCount);
			log.info(session.getId());
			try {
				JAXBContext jaxbContext = null;
				if (e != null) {
					jaxbContext = JAXBContext.newInstance(Employee.class);
				} else if(m!=null){
					jaxbContext = JAXBContext.newInstance(Manager.class);	
				}
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
				if (e != null) {
					jaxbMarshaller.marshal(e, System.out);
					jaxbMarshaller.marshal(e, response.getWriter());
				} else if(m!=null){
					jaxbMarshaller.marshal(m, System.out);
					jaxbMarshaller.marshal(m, response.getWriter());
				}
			} catch (JAXBException ex) {
				ex.printStackTrace();
			}
		}
	}

}
