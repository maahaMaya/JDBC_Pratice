package com.jdbcpack;

import java.util.*;
import java.sql.*;

public class AddNewRowDynamically {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Employee Name : ");
		String ename = sc.next();
		System.out.println("Employee Job : ");
		String job = sc.next();
		System.out.println("Employee Salary : ");
		int sal = sc.nextInt();

		String inscmd = "Insert into Employee(empName, job, salary) values('" + ename + "','" + job + "'," + sal + ")";
		System.out.println(inscmd);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conObj = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "12345");
			Statement stmt = conObj.createStatement();
			int res = stmt.executeUpdate(inscmd);
			if (res >= 1)
				System.out.println("Row Added....");
			conObj.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
