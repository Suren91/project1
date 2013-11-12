//Delete PRODUCT SERVLET

package com.suri.kart.servlet;

import java.io.*;
import java.sql.*;
import javax.servlet.*;

import javax.servlet.annotation.WebServlet;
@WebServlet(name="serv4", value="/s4")


public class DeleteProductSerlvet extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws SerlvetException, IOException
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		int pid=Integer.parseInt(request.getParameter("pid"));
                		
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
				String sql="delete from product where pid="+pid;
				Statement st=con.createStatement(sql);
				int uc=st.executeUpdate();
				if(uc==0)
				pw.println("Product delete failed no such product");
				else
				pw.println("Product deleted Successfully");
				}				 }
				finally{
				if(con!=null)
					con.close();
				}
			}catch(ClassNotFoundException cnfe){
                         pw.println("No Such Product");
			}catch(SQLException sqle){
			pw.println("No Such Product");
			}			
	pw.flush();
	pw.close();
	}
}