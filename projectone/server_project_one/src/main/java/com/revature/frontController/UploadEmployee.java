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
import com.revature.models.Employee;
import com.revature.models.ReinbursementRequest;

public class UploadEmployee extends FrontCommand {
	final static Logger log = Logger.getLogger(UploadEmployee.class);
	@Override
	public void process() throws ServletException, IOException {
		if(request.getSession(false)==null) {
			response.getWriter().append("{\"status\":\"session ended\"}");
			response.setStatus(417);
			return;			
		}
		if( !(Boolean)request.getSession(false).getAttribute(ProcessLoginPost.ISADMINKEY)) {
			response.getWriter().append("{\"status\":\"employees cant register employees\"}");
			response.setStatus(417);
			return;			
		}
		boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
		if (!isMultipartContent) {
			response.getWriter().append("{\"status\":\"Not multiparse data\"}");
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
			String email = null;
			String password = null;
			String fname = null;
			String lname = null;
			while (it.hasNext()) {
				FileItem fileItem = it.next();
				boolean isFormField = fileItem.isFormField();
				if (isFormField) {
					if (fileItem.getFieldName().equalsIgnoreCase("email"))
						email = fileItem.getString();
					if (fileItem.getFieldName().equalsIgnoreCase("password"))
						password = fileItem.getString();
					if (fileItem.getFieldName().equalsIgnoreCase("fname"))
						fname = fileItem.getString();
					if (fileItem.getFieldName().equalsIgnoreCase("lname"))
						lname = fileItem.getString();
				} 
			}
			boolean createSucessful = DatabaseSingletonService.create(new Employee(fname,lname,email,false),password);
			response.getWriter().println("{\"employee creation compleated\":\""+createSucessful+"\"}");
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}

}
