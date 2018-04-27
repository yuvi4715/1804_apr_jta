package com.revature.frontController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.log4j.Logger;
import org.eclipse.persistence.jaxb.MarshallerProperties;

import com.revature.db.DatabaseSingletonService;
import com.revature.models.ReinbursementRequest;

public class GetRequestReceipts extends FrontCommand {
	final static Logger log = Logger.getLogger(GetRequestReceipts.class);
	@Override
	public void process() throws ServletException, IOException {
		if(request.getSession(false)==null) {
			response.getWriter().append("{\"status\":\"session ended\"}");
			response.setStatus(417);
			return;			
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
			int page = 0;
			try {
				page=Integer.parseInt(request.getParameter("page"));
			} catch(NumberFormatException e) {
				e.printStackTrace();
			}
			ReinbursementRequest[] result = null;
			log.info("Get Approved?"+Boolean.parseBoolean(request.getParameter("getAproved")));
			if(Boolean.parseBoolean(request.getParameter("getAproved"))) {	
				if((Boolean)request.getSession(false).getAttribute(ProcessLoginPost.ISADMINKEY))
					result = DatabaseSingletonService.getAllRRs(page);
				else 
					result = DatabaseSingletonService.getAllRRs(page,(String) request.getSession(false).getAttribute(ProcessLoginPost.USERIDKEY));
			} else {
				if((Boolean)request.getSession(false).getAttribute(ProcessLoginPost.ISADMINKEY))
					result = DatabaseSingletonService.getAllUnresolvedRRs(page);
				else
					result = DatabaseSingletonService.getAllUnresolvedRRs(page,(String) request.getSession(false).getAttribute(ProcessLoginPost.USERIDKEY));
			}
			jaxbMarshaller.marshal(result, System.out);
			jaxbMarshaller.marshal(result, response.getWriter());
			
		} catch (JAXBException ex) {
			ex.printStackTrace();
		}
	}

}
