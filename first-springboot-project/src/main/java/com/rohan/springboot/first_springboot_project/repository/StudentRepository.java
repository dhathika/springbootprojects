package com.rohan.springboot.first_springboot_project.repository;

import java.util.List;

import com.rohan.springboot.first_springboot_project.pojo.Student;

public interface StudentRepository {
	
	public void saveStudentRepo(Student student);
	public Student selectStudentByIdRepo(int studentId);
	public List<Student> selectallStudentsRepo();
	public void deleteStudentByIdRepo(int studentId);
	public void updateStudentRepo(Student student);

}
