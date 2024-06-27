package com.rohan.springboot.first_springboot_project.service;

import java.util.List;

import com.rohan.springboot.first_springboot_project.pojo.Student;

public interface StudentService {
	
	public void saveStudentService(Student student);
	public Student selectStudentByIdService(int studentId);
	public List<Student> selectallStudentsService();
	public void deleteStudentByIdService(int studentId);
	public void updateStudentService(Student student);
	

}
