package com.rohan.springboot.first_springboot_project.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rohan.springboot.first_springboot_project.pojo.Student;
@Repository
public class StudentRepoImpl implements StudentRepository{
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void saveStudentRepo(Student student) {
		String insertQuery="insert into student1 values (" + student.getSid() + ",'"
								+ student.getSname() +"'," +student.getMarks() + ")";
		jdbcTemplate.execute(insertQuery);
	}

	@Override
	public Student selectStudentByIdRepo(int studentId) {
		String selectquery="select * from student1 where sid =" +studentId;
		List<Student> stdlist = jdbcTemplate.query(selectquery, new StudentMapper());
		return stdlist.get(0);
	}

	@Override
	public List<Student> selectallStudentsRepo() {
		String selectallQuery="select * from student1";
		List<Student> list = jdbcTemplate.query(selectallQuery, new StudentMapper());
		return list;
	}

	@Override
	public void deleteStudentByIdRepo(int studentId) {
		String deleteQuery="delete from student1 where sid =" +studentId;
		jdbcTemplate.execute(deleteQuery);
	}

	@Override
	public void updateStudentRepo(Student student) {
		String updateQuery="update student1 set sname =" +"'"+student.getSname() +"',"
							+ "marks = " +student.getMarks() + "where sid=" +
								student.getSid();
		jdbcTemplate.execute(updateQuery);
		
	}

}
