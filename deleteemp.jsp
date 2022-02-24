<%@ page import="java.sql.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%!Connection con;
		PreparedStatement ps;
		
		public void jspInit(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/jempdb","root","1593");
			ps = con.prepareStatement("delete from emp where id=?");
		}catch(Exception e){
			e.printStackTrace();
			}
		}
		
		
		
		
		public void jspDestroy(){
			try{
				ps.close();
				con.close();
			}catch(Exception e){
				e.printStackTrace();
				}
			
		}
		
		
		
		%>
		
		
	<%
		int id = Integer.parseInt(request.getParameter("id"));
		
		
	
		
		ps.setInt(1, id);
		
		ps.executeUpdate();
		
	
	%>
	
	<%@ include file="index.html" %>
	