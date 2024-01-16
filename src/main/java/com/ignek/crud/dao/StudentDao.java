package com.ignek.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.ignek.crud.connection.StudentConnection;
import com.ignek.crud.constance.StudentConstance;
import com.ignek.crud.dto.Student;

public abstract class StudentDao {
	private static void prepareMethod(Student student, PreparedStatement preparedStatement) {
		try {
			preparedStatement.setString(1, student.getFirstName());
			preparedStatement.setString(2, student.getLastName());
			preparedStatement.setString(3, student.getEmail());
			preparedStatement.setString(4, student.getPhoneNumber());
			preparedStatement.setString(5, student.getGender());
			preparedStatement.setString(6, student.getCourse());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int save(Student student) {
		int status = 0;
		try {
			Connection connection = StudentConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(StudentConstance.SAVE_QUERY);
			prepareMethod(student, preparedStatement);
			status = preparedStatement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static int update(Student student) {
		int status = 0;
		try {
			Connection connection = StudentConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(StudentConstance.UPDATE_QUERY);
			prepareMethod(student, preparedStatement);
			preparedStatement.setInt(7, student.getId());
			status = preparedStatement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static int delete(int id) {
		int status = 0;
		try {
			Connection connection = StudentConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(StudentConstance.DELETE_QUERY);
			preparedStatement.setInt(1, id);
			status = preparedStatement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static Student getStudentById(int id) {
		Student student = null;
		try {
			Connection connection = StudentConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(StudentConstance.SELECT_QUERY_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				// Use actual data from resultSet
				student = new Student(resultSet.getInt(StudentConstance.ID),
						resultSet.getString(StudentConstance.FIRSTNAME), resultSet.getString(StudentConstance.LASTNAME),
						resultSet.getString(StudentConstance.EMAIL), resultSet.getString(StudentConstance.PHONENUMBER),
						resultSet.getString(StudentConstance.GENDER), resultSet.getString(StudentConstance.COURSE));
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	public static List<Student> getAllStudents() {
		List<Student> list = new ArrayList<Student>();
		try {
			Connection connection = StudentConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(StudentConstance.SELECT_QUERY);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Student student = new Student(resultSet.getInt(StudentConstance.ID),
						resultSet.getString(StudentConstance.FIRSTNAME), resultSet.getString(StudentConstance.LASTNAME),
						resultSet.getString(StudentConstance.EMAIL), resultSet.getString(StudentConstance.PHONENUMBER),
						resultSet.getString(StudentConstance.GENDER), resultSet.getString(StudentConstance.COURSE));
				list.add(student);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
