package com.jsp.student_crud_with_prepared.service;

import com.jsp.student_crud_with_prepared.dao.StudentDao;
import com.jsp.student_crud_with_prepared.dto.Student;

public class StudentService {
	StudentDao studentDao=new StudentDao();
	/*
	 * Insert Method for Student
	 */
	public Student insertStudentService(Student student) {
		System.out.println("InsertService Method Started");
		
		if(student.getStudentId()<=9999) {
			Student student2=studentDao.insertStudent(student);
			System.out.println("InsertService Method Ended");
			return student2;
		}else {
			System.err.println("Please enter 04 Digit Id or Less then it");
		}
		return null;
	}
	public void displayStudentDetails() {
		studentDao.displayStudentDetails();
	}

}
