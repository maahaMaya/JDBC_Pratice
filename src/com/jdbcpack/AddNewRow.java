package com.jdbcpack;

import java.sql.*;

public class AddNewRow {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conObj = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "12345");
			Statement stmt = conObj.createStatement();
			int res = stmt.executeUpdate(
					"Insert into Employee(empName, job, salary) values('Kiran Kumar', 'Manager', 12000)");
			if (res >= 1)
				System.out.println("Row Added....");
			conObj.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
