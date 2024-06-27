package com.rohan.hibernate1.service;

import java.util.List;

import com.rohan.hibernate1.pojo.Student;


public interface StudentService {
	
	public void saveStudentService(Student student);
	public Student selectStudentByIdService(int studentId);
	public List<Student> selectallStudentsService();
	public void deleteStudentByIdService(int studentId);
	public void updateStudentService(Student student);

}
