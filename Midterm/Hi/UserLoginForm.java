//USER LOGIN SERVLET

package com.suri.kart.servlet;

import java.io.*;
import java.sql.*;
import javax.servlet.*;

import javax.servlet.annotation.WebServlet;
@WebServlet(name="serv1", value="/s1")


public class UserLoginSerlvet extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws SerlvetException, IOException
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String userId=request.getParameter("userId");
		String userPwd=request.getParameter("userPwd");
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
				String sql="select userpwd,role from users where userid="""+userid+"""	;
				
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(sql);
				rs.next();
				String pwd=rs.getString(1);
				String role=rs.getString(2);
				if(pwd.equals(userPwd))
				{
				  pw.println("Your Login Success");
				  if(role.equals("admin"))
				  pw.println("You are an Admin User"+getAdminForm());
				  else if(role.equals("user"))
				  pw.println("You are a Customer/User"+getUserForm());
				  else;
				  }else\
				  pw.println("Login F ailed");
				}
				finally{
				if(con!=null)
					con.close();
				}
			}catch(ClassNotFoundException cnfe){
                         pw.println("Login Failed");
			}catch(SQLException sqle){
			pw.println("Login Failed");
			}			
	pw.flush();
	pw.close();
	}
 private String getAdminForm()
{
String hd="<form action=./addProductForm.html>"
	+"<br><input type=submit value=addproduct>"
	+"</form>"
"<form action=./deleteProductForm.html>"
	+"<br><input type=submit value=deleteproduct>"
	+"</form>"	
"<form action=./viewProductForm.html>"
	+"<br><input type=submit value=viewproduct>"
	+"</form>"
return hd:

}
private String getUserForm(){
String hd="";
hd+="<form action=./viewProductForm.html>"
	+"<br><input type=submit value=viewproduct>"
	+"</form>";
return hd;
}
}