package main.Service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
public class ServerletHelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServerletHelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	/*public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init");
	}*/

	/**
	 * @see Servlet#destroy()
	 */
	/*public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy");
	}*/

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("destroy");
		super.service(request, response);
	}*/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.getWriter().append("Hello world - get method");
		System.out.println("doGet");
		PrintWriter pw = response.getWriter();
		pw.println();
		response.setContentType("text/html");
		String s1 = request.getParameter("text1");
		String s2 = request.getParameter("text2");
		pw.println("<html><body><div> "
				+ s1 + " : " + s2 + ", are the values entered </div></body></html>");
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Hello world - Post method");
		System.out.println("doPost");
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String s1 = request.getParameter("text1");
		String s2 = request.getParameter("text2");
		pw.println("<html><body><div> "
				+ s1 + " : " + s2 + ", are the values entered </div></body></html>");
		pw.close();
	}

}
