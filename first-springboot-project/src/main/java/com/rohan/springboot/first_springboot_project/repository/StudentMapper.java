package com.rohan.springboot.first_springboot_project.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rohan.springboot.first_springboot_project.pojo.Student;

public class StudentMapper implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setSid(rs.getInt(1));
		student.setSname(rs.getString(2));
		student.setMarks(rs.getDouble(3));
		
		return student;
	}

}
