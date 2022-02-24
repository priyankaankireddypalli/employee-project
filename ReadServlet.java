package com.priya.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateUserServlet
 */
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
       
    public void init() {
    	try {
    		//tomcat has disabled service provider mechanisms due to memory leackage issues
    		//therefore set it manually
    		Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/jempdb","root","1593");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from emp");
			PrintWriter out = response.getWriter();
			out.print("<table>");
			out.print("<tr>");
			out.print("<th>");
			out.println("ID");
			out.print("</th>");
			out.print("<th>");
			out.println("First Name");
			out.print("</th>");
			out.print("<th>");
			out.println("Last Name");
			out.print("</th>");
			out.print("<th>");
			out.println("Salary");
			out.print("</th>");
			out.print("</tr>");
			while(result.next()) {
				out.println("<tr>");
				out.println("<td>");
				out.print(result.getInt(1));
				out.println("</td>");
				out.println("<td>");
				out.print(result.getString(2));
				out.println("</td>");
				out.println("<td>");
				out.print(result.getString(3));
				out.println("</td>");
				out.println("<td>");
				out.print(result.getInt(4));
				out.println("</td>");
				out.println("</tr>");
			}
			out.print("</table>");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
