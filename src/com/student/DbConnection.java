package com.student;

import java.sql.*;

public class DbConnection {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "12345");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return con;
	}
}
