package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.StudentBean;
import com.dao.DAO;


@WebServlet("/saveServlet")
public class saveServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("sname");
		int contact=Integer.parseInt(request.getParameter("scontact"));
		String city=request.getParameter("scity");
		
		StudentBean s=new StudentBean();
		s.setSname(name);
		s.setScontact(contact);
		s.setScity(city);
		
		DAO d=new DAO();
		try {
			int a=d.save(s);
			if(a>0)
			{
			  response.sendRedirect("ViewServlet");
				
			}
			else
			{
				out.print("data not inserted");
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
