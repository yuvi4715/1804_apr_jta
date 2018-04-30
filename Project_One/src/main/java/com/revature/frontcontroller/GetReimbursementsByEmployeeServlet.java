package com.revature.frontcontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.eclipse.persistence.jaxb.MarshallerProperties;

import com.revature.model.Reimbursements;
import com.revature.service.ExpenseReimbursementService;

/**
 * Servlet implementation class GetReimbursementsByEmployeeServlet
 */
public class GetReimbursementsByEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetReimbursementsByEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// if(request.getSession(false)==null) {
				// response.setStatus(400);
				// return; //If user does not have a session it denies the access
				// }
		String email = request.getParameter("email");
		if(email == null) {
			response.getWriter().println("Insuficient parameters");
			return;
		} 
		try {
			JAXBContext jaxbContext = null;
			jaxbContext = JAXBContext.newInstance(Reimbursements.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
			jaxbMarshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			List<Reimbursements> returnList = null; 
			
			returnList = ExpenseReimbursementService.get_reimbursements_by_email(email);
			

			Reimbursements[] results = new Reimbursements[returnList.size()];
			results = returnList.toArray(results);

			jaxbMarshaller.marshal(results, response.getWriter());
			jaxbMarshaller.marshal(results, System.out);// Calls database and returns JSON, converts java
																	// pojo to json
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
