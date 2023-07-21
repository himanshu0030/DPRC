package com.jsp.jdbc_preparedstatement_crud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * @author Himanshu
 */

public class ProductInsertController {

	public static void main(String[] args) {
		Connection connection = null;
		try {
			// Step-01 Load/Registered Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step-02 Create Connection
			String url = "jdbc:mysql://localhost:3306/jdbc-preparedstatement";
			String user = "root";
			String pass = "2007";

			connection = DriverManager.getConnection(url, user, pass);

			String insertQuery = "insert into product values(?,?,?,?)";
			// Step-03 Create Statement
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setInt(1, 102);
			preparedStatement.setString(2, "NoteBook");
			preparedStatement.setDouble(3, 48);
			preparedStatement.setString(4, "Yellow");
			
			//Step-04 Execute Query

			preparedStatement.execute();

			System.out.println("=====Date Stored=======");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				//Step-05   Close Connection
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
