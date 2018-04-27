package com.revature.frontController;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import com.revature.db.DatabaseSingletonService;
import com.revature.models.ReinbursementRequest;

public class UpdateReinbursementReceipt extends FrontCommand {
	final static Logger log = Logger.getLogger(UpdateReinbursementReceipt.class);
	@Override
	public void process() throws ServletException, IOException {
		if (request.getSession(false) == null) {
			response.getWriter().append("{\"status\":\"session ended\"}");
			response.setStatus(417);
			return;
		}
		if (!(Boolean) request.getSession(false).getAttribute(ProcessLoginPost.ISADMINKEY)) {
			response.getWriter().append("{\"status\":\"employees cant register employees\"}");
			response.setStatus(417);
			return;
		}
		boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
		if (!isMultipartContent) {
			System.out.println("{\"status\":\"Not multiparse data\"}");
			response.setStatus(417);
			return;
		}
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> fields = upload.parseRequest(request);
			Iterator<FileItem> it = fields.iterator();
			if (!it.hasNext()) {
				System.out.println("No fields found");
				return;
			}
			String id = null;
			String image = null;
			String DESCRIPTION = null;
			String ISDELETED = null;
			String STATUS = null;
			String HANDLEDBY = null;
			String AMOUNT = null;
			while (it.hasNext()) {
				FileItem fileItem = it.next();
				boolean isFormField = fileItem.isFormField();
				if (isFormField) {
					if (fileItem.getFieldName().equalsIgnoreCase("id"))
						id = fileItem.getString();
					if (fileItem.getFieldName().equalsIgnoreCase("image"))
						image = fileItem.getString();
					if (fileItem.getFieldName().equalsIgnoreCase("DESCRIPTION"))
						DESCRIPTION = fileItem.getString();
					if (fileItem.getFieldName().equalsIgnoreCase("ISDELETED"))
						ISDELETED = fileItem.getString();
					if (fileItem.getFieldName().equalsIgnoreCase("STATUS"))
						STATUS = fileItem.getString();
					if (fileItem.getFieldName().equalsIgnoreCase("HANDLEDBY"))
						HANDLEDBY = fileItem.getString();
					if (fileItem.getFieldName().equalsIgnoreCase("AMOUNT"))
						AMOUNT = fileItem.getString();
				}
			}
			long longID = -1;
			try {
				longID = Long.parseLong(id);
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
			}
			if (longID >= 0) {
				ReinbursementRequest rr = DatabaseSingletonService.readRR(longID);
				if (rr != null) {
					double amountDouble = -1;
					try {
						if (AMOUNT != null)
							amountDouble = Double.parseDouble(AMOUNT);
					} catch (NumberFormatException e) {
						System.out.println(e.getMessage());
					}
					if (amountDouble >= 0)
						rr.setAmount(amountDouble);
					if (image != null)
						rr.setImageURL(image);
					if (DESCRIPTION != null)
						rr.setImageURL(DESCRIPTION);
					if (HANDLEDBY != null) {
						rr.setHandledBy(DatabaseSingletonService.readManager(HANDLEDBY));
					}
					short statusDouble = -1;
					try {
						if (STATUS != null)
							statusDouble = Short.parseShort(STATUS);
					} catch (NumberFormatException e) {
						System.out.println(e.getMessage());
					}
					if (statusDouble >= 0)
						rr.setStatus(statusDouble);
					boolean updatesuccessful = DatabaseSingletonService.update(rr);
					response.getWriter().println("{\"update copleated\":\"" + updatesuccessful + "\"}");
					return;
				}
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		response.getWriter().println("{\"update copleated\":\"false\"}");
	}

}
