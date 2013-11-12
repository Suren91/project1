//VIEW PRODUCT SERVLET

package com.suri.kart.servlet;

import java.io.*;
import java.sql.*;
import javax.servlet.*;


import javax.servlet.annotation.WebServlet;
@WebServlet(name="serv5", value="/s5")

public class VeiwProductSerlvet extends HttpServlet
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
				String sql="select pname,unitprice from PRODUCT where pid="""+pid+"""	;
				
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(sql);
				rs.next();
				String pname=rs.getString(1);
				String unitprice=rs.getString(2);
				pw.println("pid:"+pid);
				pw.println("pname:"+pname);
				pw.println("unitprice"+unitprice);
				 }
				finally{
				if(con!=null)
					con.close();
				}
			}catch(ClassNotFoundException cnfe){
                         pw.println("No such product");
			}catch(SQLException sqle){
			pw.println("No such product");
			}			
	pw.flush();
	pw.close();
	}
}