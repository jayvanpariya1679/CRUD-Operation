package com.ignek.crud.connection;

import com.ignek.crud.constance.StudentConstance;

import java.sql.*;

public class StudentConnection {

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(StudentConstance.DRIVER);
			connection = DriverManager.getConnection(StudentConstance.PATH, StudentConstance.USER,
					StudentConstance.PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
