package com.dprc.customerApp.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class RegisteredDriverController {
	public static void main(String[] args) {
		Connection con = null;
		try {
			// Step-01 Registered Driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			// Step-02 Create Connection
			String url = "jdbc:mysql://localhost:3306/advjava";
			String user = "root";
			String pass = "2007";

			con = DriverManager.getConnection(url, user, pass);

			// Step-03 Create Statement
			Statement st = con.createStatement();

			// Step-04 Execute Query
			String displayQuery = "select * from customer";
			ResultSet resultSet = st.executeQuery(displayQuery);
			while (resultSet.next()) {
				int id = resultSet.getInt("idcustomer");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				long phone = resultSet.getLong("mobile");

				System.out.println("Customer ID :" + id);
				System.out.println("Name : " + name);
				System.out.println("Email : " + email);
				System.out.println("Phone No : " + phone);
				System.out.println("========================");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		} finally {
			try {
				// Step-05 Close Connection
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
