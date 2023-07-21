package com.dprc.customerApp.controller;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Controller {
	public static void main(String[] args) {
		Connection con=null;
		try {
			//Step 1
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Step 2
			String url="jdbc:mysql://localhost:3306/advjava";
			String user="root";
			String pass="2007";
			
			con=DriverManager.getConnection(url, user, pass);
			
			//Step 3
			Statement st = con.createStatement();
			
			//Step 4
			String insertCustomerQuery="insert into customer(idcustomer, name, mobile, email) values(104,'Kundan',0919745869712,'neeraj@gmail.com')";
			st.execute(insertCustomerQuery);
			System.out.println("=====DATA ADDED=====");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				//Step 5
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
