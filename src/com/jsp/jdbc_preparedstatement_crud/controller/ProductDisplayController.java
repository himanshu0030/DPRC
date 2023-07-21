package com.jsp.jdbc_preparedstatement_crud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductDisplayController {
	static Connection connection = null;
	public static void main(String[] args) {
		//Connection connection = null;
		try {
			// Step-01 Load/Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step-02 Create Connection
			String url = "jdbc:mysql://localhost:3306/jdbc-preparedstatement";
			String user = "root";
			String pass = "2007";

			connection = DriverManager.getConnection(url, user, pass);

			// Step-03 Create Statement
			String DisplayQuery = "Select * from product";
			PreparedStatement preparedStatement = connection.prepareStatement(DisplayQuery);

			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int id=resultSet.getInt("productid");
				String name=resultSet.getString("productname");
				double price=resultSet.getDouble("productprice");
				String color=resultSet.getString("productcolor");
				
				System.out.println("Product Id: "+id);
				System.out.println("Product Name: "+name);
				System.out.println("Product Price: "+price);
				System.out.println("Product Color: "+color);
				System.out.println("==========================");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
