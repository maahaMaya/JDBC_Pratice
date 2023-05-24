package com.jdbcpack;

import java.sql.*;
import java.util.Scanner;

public class SearchEmp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Employee ID : ");
		int eno = sc.nextInt();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conObj = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "12345");
			Statement stmt = conObj.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from Employee where empid=" + eno);

			if (rs.next()) {
				System.out.println("Employee ID : " + rs.getInt("empid"));
				System.out.println("Employee Name : " + rs.getString("empname"));
				System.out.println("Employee Job : " + rs.getString("job"));
				System.out.println("Employee Salary : " + rs.getInt("salary"));
			} else
				System.out.println("Employee Not Found....");
			rs.close();
			conObj.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
