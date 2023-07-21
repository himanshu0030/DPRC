package com.jsp.student_crud_with_prepared.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentConnection {
	public static Connection getStudentConnection() {
		try {
			//Step-01 Load/Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Step-02 Create Connection
			String url="jdbc:mysql://localhost:3306/jdbc-preparedstatement";
			String user="root";
			String pass="2007";
			
			Connection connection= DriverManager.getConnection(url,user,pass);
			return connection;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
