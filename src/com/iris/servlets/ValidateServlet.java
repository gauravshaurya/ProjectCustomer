package com.iris.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iris.dao.CustomerDao;
import com.iris.daoImpl.CustomerDaoImpl;
import com.iris.model.Customer;


@WebServlet("/login")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ValidateServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		response.setContentType("text/html");
	
		
		
		String s1=request.getParameter("uname");
		String s2=request.getParameter("passw");
		
		
		
		PrintWriter out=response.getWriter();
		CustomerDao custdao = new CustomerDaoImpl();
		
		
		boolean r=false;
		r=custdao.validateCustomer(s1,s2);
		
		if(r)
		{
			out.println("Success");
		}
		else {
			out.println("not");
		}
		
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
}
