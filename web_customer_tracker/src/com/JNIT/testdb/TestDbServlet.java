package com.JNIT.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection myCon = null;
		String URL = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String username = "springstudent";
		String password = "springstudent";

		try {
			
			PrintWriter out = response.getWriter();
			out.println("Connnecting the database : " + URL);
			myCon = DriverManager.getConnection(URL, username, password);
			
			out.println("Sucess!");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				myCon.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
