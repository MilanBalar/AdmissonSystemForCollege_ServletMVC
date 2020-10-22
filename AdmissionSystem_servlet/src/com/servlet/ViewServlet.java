package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.StudentBean;
import com.dao.DAO;


@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		try {
			List<StudentBean> s=DAO.getdata();
			 out.print("All Data");
		    out.print("<table border='1'>");
		    out.print("<h1><tr> <th>ID </th> <th> Name </th>  <th>Contact </th> <th>City </th>  <th>Delete </th> <th>Edit </th>    </tr><h1>");
		     
		    for(StudentBean m:s)
		    {
		    	out.println("<tr>  <td>"+m.getSid()+"</td><td>"+m.getSname()+"</td><td>"+m.getScontact()+"</td><td>"+m.getScity()+"</td><td><a href='DeleteServlet?sid="+m.getSid()+"'>Delete</a>  </td><td><a href='EditServlet?sid="+m.getSid()+"'>Edit</a>  </td> </tr>");
		    	
		    	
		    }
		   
		    
		    out.print("</table>");
		    
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}

}
