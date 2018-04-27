package com.revature.frontController;

import java.io.File;
import java.io.FileOutputStream;
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

public class UploadReinbursementReceipt extends FrontCommand {
	final static Logger log = Logger.getLogger(UploadReinbursementReceipt.class);
	private String amount;
	private String description;
	private String endpoint = "http://localhost:8080/ProjectOne/";

	@Override
	public void process() throws ServletException, IOException {
		if(request.getSession(false)==null) {
			response.getWriter().append("{\"status\":\"session ended\"}");
			response.setStatus(417);
			return;			
		}
		if( (Boolean)request.getSession(false).getAttribute(ProcessLoginPost.ISADMINKEY)) {
			response.getWriter().append("{\"status\":\"admin cant register receipts\"}");
			response.setStatus(417);
			return;			
		}
			
		boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
		if (!isMultipartContent) {
			response.getWriter().print("{\"status\":\"Not multiparse data\"}");
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
			FileItem file=null;
			while (it.hasNext()) {
				FileItem fileItem = it.next();
				boolean isFormField = fileItem.isFormField();
				if (isFormField) {
					if (fileItem.getFieldName().equalsIgnoreCase("amount"))
						amount = fileItem.getString();
					if (fileItem.getFieldName().equalsIgnoreCase("description"))
						description = fileItem.getString();
				} else {
					// log.info(fileItem.getFieldName() + "\nSTRING: " +
					// fileItem.getString() + "\nNAME: "
					// + fileItem.getName() + "\nCONTENT TYPE: " + fileItem.getContentType() +
					// "\nSIZE (BYTES): "
					// + fileItem.getSize() + "\nTO STRING: " + fileItem.toString());
					// log.info("Working Directory = " +
					// System.getProperty("user.dir"));
					file = fileItem;
				}
			}
			try {
				String s = "./src/main/webapp/images/" + file.getName();
				File f = new File(s);
				int count = 0;
				while (f.exists()) {
					count++;
					f = new File(s+"(" + count + ")");
				}
				FileOutputStream fos = new FileOutputStream(f);
				fos.write(file.get());
				fos.close();
				ReinbursementRequest r = new ReinbursementRequest(0L,
						endpoint + "images/" + file.getName() + (count > 0 ? "(" + count + ")" : ""),
						null,
						DatabaseSingletonService.readEmployee(
								(String) request.getSession(false).getAttribute(ProcessLoginPost.USERIDKEY)),
						description, Double.parseDouble(amount), (short) 0, false);
				boolean createSucessful = DatabaseSingletonService.create(r);
				response.getWriter().println("{\"filecreation compleated\":\""+createSucessful+"\"}");
			} catch (NumberFormatException e) {
			} catch (IOException e) {
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}
}
