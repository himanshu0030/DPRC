package com.jsp.jdbc_preparedstatement_crud.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ProductDeleteController {
	public static void main(String[] args) {
		Connection connection = null;
		try {
			// Step-01 Load/Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step-02 Create Connection
			String url = "jdbc:mysql://localhost:3306/jdbc-preparedstatement";
			String user = "root";
			String pass = "2007";

			connection = DriverManager.getConnection(url, user, pass);

			// Step-03 Create Statement
			String updateColorQuery="delete from product where productid=?";
			
			PreparedStatement preparedStatement=connection.prepareStatement(updateColorQuery);
			preparedStatement.setInt(1, 101);
			
			//Step-04 Execute Query 
			int a=preparedStatement.executeUpdate();
			if(a==1) {
				System.out.println("Data is Deleted Successfully");
			}else {
				System.err.println("Given ID is not Present");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
