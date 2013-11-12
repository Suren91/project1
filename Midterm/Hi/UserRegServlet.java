//USER REGISTRATION SERVLET

package com.suri.kart.servlet;

import java.io.*;
import java.sql.*;
import javax.servlet.*;


import javax.servlet.annotation.WebServlet;
@WebServlet(name="serv2", value="/s2")


public class UserRegSerlvet extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws SerlvetException, IOException
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String userId=request.getParameter("userId"));
                String name=request.getParameter("name");
		String userPwd=request.getParameter("userPwd");
		String gender=request.getParameter("gender"));
                String phone=request.getParameter("phoneNum");
		
		int phoneNum=Integer.parseInt(phone);
		
		String driverClass="oracle.jdbc.driver.OracleDriver";
		String dburl="jdbc:oracle:thin:@devserver:1521:devorcl";
		String dbuser="devsystem";
		String dbpassword="devpass";
		try
		{
			Class.forName(driverclass);
			Connection con=null;
			try
			{
				con=DriverManager.getConnection(dburl,dbuser,dbpassword);
				String sql="insert into user values(?,?,?,?,?,?)";
				PreparedStatement pst=con.prepareStatement(sql);
				pst.setString(1,userId);
				pst.setString(2,userPwd);
				pst.setString(3,name);
				pst.setString(4,gender);
				pst.setInt(5,phoneNum);
				pst.setString(6,"user");
				
				int uc=pst.executeUpdate();
				if(uc==0)
				pw.println("Registration failed");
				else
				pw.println("Registration Success");
				}				 }
				finally{
				if(con!=null)
					con.close();
				}
			}catch(ClassNotFoundException cnfe){
                         pw.println("Registration failed");
			}catch(SQLException sqle){
			pw.println("Registration failed");
			}			
	pw.flush();
	pw.close();
	}
}