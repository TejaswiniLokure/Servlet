package com.te.servlet1.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginPage extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int employeeid = Integer.parseInt(req.getParameter("id"));
		String employeename = req.getParameter("name");
		String email = req.getParameter("email");
		int employeesal = Integer.parseInt(req.getParameter("sal"));
		PrintWriter writer=resp.getWriter();
		int res = LoginJDBC.addEmployee(employeeid, employeename, email, employeesal);
		if (res == 1) {
			writer.println("data recieved");
			
		} else {
			writer.println("data is not received");
		}

//		if("password".equals(password)&&"admin".equals(username))
//		{
//			 HttpSession session = req.getSession();
//			 session.setAttribute(username, password);
//			 resp.sendRedirect("Success.jsp");
//		}
//		else {
//			resp.sendRedirect("Error.jsp");
//		}
//		

	}

}
