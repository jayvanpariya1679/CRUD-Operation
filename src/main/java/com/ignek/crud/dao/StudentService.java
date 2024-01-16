package com.ignek.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.ignek.crud.connection.DBConnection;
import com.ignek.crud.constance.StudentConstance;
import com.ignek.crud.dto.Student;

public abstract class StudentService {
	private static void setPreparedStatement(Student student, PreparedStatement preparedStatement) {
		try {
			preparedStatement.setString(1, student.getFirstName());
			preparedStatement.setString(2, student.getLastName());
			preparedStatement.setString(3, student.getEmail());
			preparedStatement.setLong(4, student.getPhoneNumber());
			preparedStatement.setString(5, student.getGender());
			preparedStatement.setString(6, student.getCourse());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int save(Student student) {
		int status = StudentConstance.DEFAULT_INTEGER;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(StudentConstance.SAVE_QUERY);
			setPreparedStatement(student, preparedStatement);
			status = preparedStatement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static int update(Student student) {
		int status = StudentConstance.DEFAULT_INTEGER;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(StudentConstance.UPDATE_QUERY);
			setPreparedStatement(student, preparedStatement);
			preparedStatement.setInt(7, student.getId());
			status = preparedStatement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static int delete(int id) {
		int status = StudentConstance.DEFAULT_INTEGER;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(StudentConstance.DELETE_QUERY);
			preparedStatement.setInt(1, id);
			status = preparedStatement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	private static void setStudentData(Student student, ResultSet resultSet) {
		try {
			student.setId(resultSet.getInt(1));
			student.setFirstName(resultSet.getString(2));
			student.setLastName(resultSet.getString(3));
			student.setEmail(resultSet.getString(4));
			student.setPhoneNumber(resultSet.getLong(5));
			student.setGender(resultSet.getString(6));
			student.setCourse(resultSet.getString(7));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Student getStudentById(int id) {
		Student student = new Student();
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(StudentConstance.SELECT_QUERY_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				setStudentData(student, resultSet);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	public static List<Student> getAllStudents() {
		List<Student> list = new ArrayList<>();
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(StudentConstance.SELECT_QUERY);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Student student = new Student();
				setStudentData(student, resultSet);
				list.add(student);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
