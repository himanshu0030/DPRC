package com.jsp.student_crud_with_prepared.controller;

import java.util.Scanner;

import com.jsp.student_crud_with_prepared.dao.StudentDao;
import com.jsp.student_crud_with_prepared.dto.Student;
import com.jsp.student_crud_with_prepared.service.StudentService;

public class StudentController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Main Method Started");
		Student student = null;
		StudentService studentService = new StudentService();
		System.out.println("1. Insert \n2. Update \n3. Display \n4. Exit");
		System.out.println("Enter your choice : ");
		int ch = sc.nextInt();
		switch (ch) {
		case 1: {
			System.out.println("Enter Student Id :");
			int id = sc.nextInt();
			System.out.println("Enter Student Name :");
			String name = sc.next();
			System.out.println("Enter Student Email :");
			String email = sc.next();
			System.out.println("Enter Student Phone Number :");
			long phone = sc.nextLong();
			student = new Student(id, name, email, phone);
			studentService.insertStudentService(student);
		}
			break;
		case 2: {
			System.out.println("1. Name\n2. Email \n3. Phone");
			System.out.println("please choose any option");
			int ch1 = sc.nextInt();
			switch (ch1) {
			case 1:
				System.out.println("Enter the Student ID : ");
				int id=sc.nextInt();
				System.out.println("Enter Student Name : ");
				String name=sc.next();
				
				//int id1=studentService.
			}

		}
			break;
		case 3: {
			System.out.println("Student Details");
			studentService.displayStudentDetails();
		}break;
		case 4: {
			System.out.println("Thank You for Visit");
		}break;
		}

		System.out.println("Main Method Ended");
	}

}
