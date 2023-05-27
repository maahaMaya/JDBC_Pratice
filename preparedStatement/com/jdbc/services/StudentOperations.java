package com.jdbc.services;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.connection.*;
import com.jdbc.model.*;

public class StudentOperations {

	private Connection conObj = null;

	public StudentOperations() {
		conObj = DbConnection.getConnection();
	}

	public String AddNewStudent(Student std) {
		String res = "Error";
		try {

			String inscmd = "Insert into Student(studentdName, course, fees) values(?, ?, ?)";

			PreparedStatement ps = conObj.prepareStatement(inscmd);
			ps.setString(1, std.getStdname());
			ps.setString(2, std.getCourse());
			ps.setFloat(3, std.getFees());

			int r = ps.executeUpdate();
			if (r >= 1)
				res = "Success";
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
			PreparedStatement preparedStatement = conObj.prepareStatement("Select * from Student");
			ResultSet rs = preparedStatement.executeQuery();

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
			PreparedStatement preparedStatement = conObj.prepareStatement("Select * from Student where rollno= ?");
			preparedStatement.setInt(1, rollno);
			ResultSet rs = preparedStatement.executeQuery();

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
			String delCmd = "Delete from Student where rollno= ?";
			PreparedStatement preparedStatement = conObj.prepareStatement(delCmd);
			preparedStatement.setInt(1, rollno);
			int r = preparedStatement.executeUpdate();
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
			String uptCmd = "Update Student set studentdName= ? where rollno= ?";
			PreparedStatement preparedStatement = conObj.prepareStatement(uptCmd);
			preparedStatement.setString(1, std.getStdname());
			preparedStatement.setInt(2, std.getRollno());
			int r = preparedStatement.executeUpdate();
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
