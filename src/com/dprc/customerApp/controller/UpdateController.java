package com.dprc.customerApp.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateController {
	public static void main(String[] args) {
		Connection con=null;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Customer ID to Update Email : ");
		int id=scanner.nextInt();
		
		System.out.println("Enter New Email ID :");
		String email=scanner.next();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/advjava";
			String user="root";
			String pass="2007";
			
			con= DriverManager.getConnection(url, user, pass);
			
			Statement st= con.createStatement();
			
			String UpdateCustomerQuery="update customer set email='"+email+"' WHERE idcustomer="+id;
			int a=st.executeUpdate(UpdateCustomerQuery);
			if(a==1) {
				System.out.println("----Data Updated----");
			}else {
				System.out.println("Given ID is not Present");
			}
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
	}

}
