package com.lti.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.entity.Customer;
import com.lti.entity.CustomerDao;


public class MyServlet1 extends HttpServlet {

	
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  response.setContentType("text/html");
		   PrintWriter out = response.getWriter();
		   
		   
			 Customer c = new Customer();
			 
			 
			String name =  request.getParameter("name");
			String email=  request.getParameter("email");
			String date = request.getParameter("dob");
			 
			 c.setName(name);
			 c.setMail(email);
			 c.setDateOfBirth(LocalDate.parse(date));
			 
			 
			  CustomerDao dao = new CustomerDao(); 
			  dao.store(c);
			  
			  out.println("data stored!!");
			  
	}

}
