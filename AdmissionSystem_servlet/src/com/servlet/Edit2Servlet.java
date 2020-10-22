package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.StudentBean;
import com.dao.DAO;

/**
 * Servlet implementation class Edit2Servlet
 */
@WebServlet("/Edit2Servlet")
public class Edit2Servlet extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		StudentBean s=new StudentBean();
		s.setSid(Integer.parseInt(request.getParameter("id")));
		s.setSname(request.getParameter("name"));
		s.setScontact(Integer.parseInt(request.getParameter("contact")));
		s.setScity(request.getParameter("city"));
		
		
		try {
			int n=DAO.Edit2(s);
			if(n>0)
			{
				response.sendRedirect("ViewServlet");
			}
			else
			{
				
				out.print("not update");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
