package com.jdbcpack;

import java.sql.*;

public class ShowAllEmps {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conObj = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "12345");
			Statement stmt = conObj.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from Employee");

			while (rs.next()) {
				System.out.println("Employee ID : " + rs.getInt("empId"));
				System.out.println("Employee Name : " + rs.getString("empName"));
				System.out.println("Employee Job : " + rs.getString("job"));
				System.out.println("Employee Salary : " + rs.getInt("salary"));
				System.out.println("----------------------------------------");
			}
			rs.close();
			conObj.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
