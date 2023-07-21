package com.jsp.student_crud_with_prepared.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsp.student_crud_with_prepared.connection.StudentConnection;
import com.jsp.student_crud_with_prepared.dto.Student;

public class StudentDao {
	Connection connection = StudentConnection.getStudentConnection();

	/*
	 * Insert method for Student
	 */
	public Student insertStudent(Student student) {
		String insertQuery = "insert into student values(?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setInt(1, student.getStudentId());
			preparedStatement.setString(2, student.getStudentName());
			preparedStatement.setString(3, student.getStudentEmail());
			preparedStatement.setLong(4, student.getStudentPhone());

			preparedStatement.execute();

			System.out.println("Record Insert Successfully");
			return student;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}/* Insert Method Ended */

	/*
	 * Update Student Data Method
	 */
	public int updateStudentName(int studentId, String studentName) {
		String updateStudentNameQuery = "update student set name=? where id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(updateStudentNameQuery);
			preparedStatement.setInt(2, studentId);
			preparedStatement.setString(1, studentName);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void displayStudentDetails() {
		String displayStudentQuery = "select * from student";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(displayStudentQuery);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				long phone = resultSet.getLong("phone");

				System.out.println("ID = " + id);
				System.out.println("Name = " + name);
				System.out.println("Email = " + email);
				System.out.println("Phone = " + phone);
				System.out.println("=============================");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
