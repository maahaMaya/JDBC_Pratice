package com.student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentOperations {

	private Connection conObj = null;

	public StudentOperations() {
		conObj = DbConnection.getConnection();
	}

	public String AddNewStudent(Student std) {
		String res = "Error";
		try {
			// Insert into Student(studentdName, course, fees) values('murali','java',12000);
			String inscmd = "Insert into Student(studentdName, course, fees) values('" + std.getStdname() + "','"
					+ std.getCourse() + "'," + std.getFees() + ")";
			Statement stmt = conObj.createStatement();
			int r = stmt.executeUpdate(inscmd);
			if (r >= 1)
				res = "Success";
			// conObj.close();
		} catch (Exception ex) {
			res = ex.getMessage();
			ex.printStackTrace();
		}
		return res;
	}

	public List<Student> ShowAll() {
		List<Student> sall = new ArrayList<Student>();
		Student std = null;
		try {
			Statement stmt = conObj.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from Student");

			while (rs.next()) {
				std = new Student();
				std.setRollno(rs.getInt("rollno"));
				std.setStdname(rs.getString("studentdName"));
				std.setCourse(rs.getString("course"));
				std.setFees(rs.getFloat("fees"));
				sall.add(std);
			}
			// conObj.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return sall;
	}

	public Student SearchStudent(int rollno) {
		Student std = null;
		try {
			Statement stmt = conObj.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from Student where rollno=" + rollno);

			if (rs.next()) {
				std = new Student();
				std.setRollno(rs.getInt("rollno"));
				std.setStdname(rs.getString("studentdName"));
				std.setCourse(rs.getString("course"));
				std.setFees(rs.getFloat("fees"));
			}
			// conObj.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return std;
	}

	public String DeleteStudent(int rollno) {
		String res = "Error";
		try {
			// Delete from Student where rollno=1
			String delcmd = "Delete from Student where rollno=" + rollno;
			Statement stmt = conObj.createStatement();
			int r = stmt.executeUpdate(delcmd);
			if (r >= 1)
				res = "Success";
			// conObj.close();
		} catch (Exception ex) {
			res = ex.getMessage();
			ex.printStackTrace();
		}
		return res;
	}

	public String UpdateStudentName(Student std) {
		String res = "Error";
		try {
			// Update Student set stdname='nagesh' where rollno=2;
			String uptcmd = "Update Student set studentdName='" + std.getStdname() + "' where rollno=" + std.getRollno();
			Statement stmt = conObj.createStatement();
			int r = stmt.executeUpdate(uptcmd);
			if (r >= 1)
				res = "Success";
			// conObj.close();
		} catch (Exception ex) {
			res = ex.getMessage();
			ex.printStackTrace();
		}
		return res;
	}
}
