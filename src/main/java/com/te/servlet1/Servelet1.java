package com.te.servlet1;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/insert")
public class Servelet1 extends  GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		 res.setContentType("text/html");
	        PrintWriter writer = res.getWriter();
	        writer.println("data recieved");
	               writer.close();
 
		
	}

	}
