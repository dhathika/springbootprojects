package com.rohan.hibernate1.repository;

import java.util.List;

import com.rohan.hibernate1.pojo.Student;


public interface StudentRepository {
	
	public void saveStudentRepo(Student student);
	public Student selectStudentByIdRepo(int studentId);
	public List<Student> selectallStudentsRepo();
	public void deleteStudentByIdRepo(int studentId);
	public void updateStudentRepo(Student student);

}
