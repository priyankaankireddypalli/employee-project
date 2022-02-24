<%@ page import="java.sql.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%!Connection con;
		PreparedStatement ps;
		
		public void jspInit(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/jempdb","root","1593");
			ps = con.prepareStatement("insert into emp values(?,?,?,?)");
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
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		int sal = Integer.parseInt(request.getParameter("salary"));
		
		
	
		
		ps.setInt(1, id);
		ps.setString(2, firstName);
		ps.setString(3, lastName);
		ps.setInt(4, sal);
		
		ps.executeUpdate();
		
	
	%>
	
	
	
	<%@ include file="index.html" %>
	