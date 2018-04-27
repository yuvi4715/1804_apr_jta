package com.revature.frontController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.log4j.Logger;
import org.eclipse.persistence.jaxb.MarshallerProperties;

import com.revature.db.DatabaseSingletonService;
import com.revature.models.Employee;

public class GetAllEmployees extends FrontCommand {
	final static Logger log = Logger.getLogger(GetAllEmployees.class);
	@Override
	public void process() throws ServletException, IOException {
		if(request.getSession(false)==null) {
			response.getWriter().append("{\"status\":\"session ended\"}");
			response.setStatus(417);
			return;			
		}
		log.info("isAdmin"+request.getSession(false).getAttribute(ProcessLoginPost.ISADMINKEY));
		if(!(Boolean)request.getSession(false).getAttribute(ProcessLoginPost.ISADMINKEY)) {
			response.getWriter().append("{\"isAdmin\":\"false\"}");
			response.setStatus(417);
			return;
		}
		try {
			JAXBContext jaxbContext = null;
			jaxbContext = JAXBContext.newInstance(Employee.class);
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
			int page = 0;
			try {
				page=Integer.parseInt(request.getParameter("page"));
			} catch(NumberFormatException e) {
				e.printStackTrace();
			}
			Employee[] result = DatabaseSingletonService.getAllEmployees(page);
			jaxbMarshaller.marshal(result, System.out);
			jaxbMarshaller.marshal(result, response.getWriter());
			
		} catch (JAXBException ex) {
			ex.printStackTrace();
		}
	}

}
