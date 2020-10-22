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
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("sid"));
	    
		try {
			StudentBean sb=DAO.updateData(id);
			out.print("<h1 align='center'>Update Data</h1>");	
		out.print("<form action='Edit2Servlet' method='post'>");
		out.print("<b><table border='1' align='center'></b>");
		
		out.print("<tr> <td>ID </td><td><input type='text' name='id' value="+sb.getSid()+" ></td></tr>");
		out.print("<tr> <td>Name </td><td><input type='text' name='name' value="+sb.getSname()+" ></td></tr>");
		out.print("<tr> <td>Contact </td><td><input type='number' name='contact' value="+sb.getScontact()+" ></td></tr>");
		out.print("<tr> <td>City </td><td><input type='text' name='city' value="+sb.getScity()+" ></td></tr>");
		
		out.print("<tr> <td><input type='submit'  value='Update' ></td></tr>");
		
			  
			  
			out.print("</table>");


			out.print("</form>");	
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

	
}
