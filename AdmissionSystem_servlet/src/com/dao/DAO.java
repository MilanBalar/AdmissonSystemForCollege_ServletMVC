package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.StudentBean;

public class DAO 
{
	
	public static Connection geConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_project","root","");
		return con;
	}
	
	public static int Edit2(StudentBean s) throws ClassNotFoundException, SQLException 
	{  
	Connection con=DAO.geConnection();
	PreparedStatement ps=con.prepareStatement("update student set sname=?,scontact=?,scity=? where sid=?");
	ps.setString(1,s.getSname());
	ps.setInt(2,s.getScontact());
 	ps.setString(3,s.getScity());
 	ps.setInt(4,s.getSid());
 	
	int m=ps.executeUpdate();
		
		
		
		return m;
	}
	
	
	
	public static StudentBean updateData(int id) throws ClassNotFoundException, SQLException
	{ 
		StudentBean s=new StudentBean();
		Connection con=DAO.geConnection();
		PreparedStatement ps=con.prepareStatement("select * from student where sid=?");
		ps.setInt(1,id);
     	ResultSet rs=ps.executeQuery();
     	while(rs.next())
     		{
     		
     		
  	   s.setSid(rs.getInt(1));
  	   s.setSname(rs.getString(2));
  	   s.setScontact(rs.getInt(3));
  	   s.setScity(rs.getString(4));
  	  
     	
     		}
		
		
		return s;
	}
	
	public static int deletedata(int sid) throws ClassNotFoundException, SQLException 
	{   int m;
	    Connection con=DAO.geConnection();
	    PreparedStatement ps=con.prepareStatement("delete from student where sid=?");
		ps.setInt(1,sid);
		
		m=ps.executeUpdate();
		return m;
	}
	
	
	
	
	
	
	public static List<StudentBean> getdata() throws ClassNotFoundException, SQLException 
	{
		
		List<StudentBean> l=new ArrayList<StudentBean>();
		Connection con=DAO.geConnection();
		PreparedStatement ps=con.prepareStatement("select * from student");
     	ResultSet rs=ps.executeQuery();
     	while(rs.next())
     	{ StudentBean s=new StudentBean();
     	   s.setSid(rs.getInt(1));
     	   s.setSname(rs.getString(2));
     	   s.setScontact(rs.getInt(3));
     	   s.setScity(rs.getString(4));
     	  l.add(s);
     	}
     	
     	
     	return l;
		
		
		
	}
	
	
	
	public int save(StudentBean s) throws ClassNotFoundException, SQLException
	{
		Connection con=DAO.geConnection();
		PreparedStatement ps=con.prepareStatement("insert into student(sname,scontact,scity) values(?,?,?)");
		ps.setString(1, s.getSname());
		ps.setInt(2,s.getScontact());
		ps.setString(3,s.getScity());
	int a=ps.executeUpdate();
	return a;
		

	}
	

}
