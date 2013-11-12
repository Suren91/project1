//ADD PRODUCT SERVLET

package com.suri.kart.servlet;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
@WebServlet(name="serv3", value="/s3")

public class AddProductSerlvet extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws SerlvetException, IOException
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String pid=request.getParameter("pid"));
                String pname=request.getParameter("pname");
		String price=request.getParameter("unitprice");
		int unitprice=Integer.parseInt(price);
		
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
				String sql="insert into product values(?,?,?)";
				PreparedStatement pst=con.prepareStatement(sql);
				pst.setInt(1,Integer.parseInt(pid));
				pst.setString(2,pname);
				pst.setInt(3,unitprice);
				int uc=pst.executeUpdate();
				if(uc==0)
				pw.println("Product adding failed");
				else
				pw.println("Product added Successfully");
				}				 }
				finally{
				if(con!=null)
					con.close();
				}
			}catch(ClassNotFoundException cnfe){
                         pw.println("Product adding failed");
			}catch(SQLException sqle){
			pw.println("Product adding failed");
			}			
	pw.flush();
	pw.close();
	}
}