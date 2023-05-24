package com.jdbcpack;

import java.sql.*;

public class DbConnection {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conObj = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "12345");
			if (conObj != null) {
				System.out.println("Connection is Successfully");
			} else {
				System.out.println("Try again.....");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
