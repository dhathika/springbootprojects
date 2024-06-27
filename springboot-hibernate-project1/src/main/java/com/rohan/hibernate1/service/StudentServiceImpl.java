package com.rohan.hibernate1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohan.hibernate1.pojo.Student;
import com.rohan.hibernate1.repository.StudentRepoImpl;
@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	 private StudentRepoImpl studentRepoImpl;
	
	

	public StudentRepoImpl getStudentRepoImpl() {
		return studentRepoImpl;
	}

	public void setStudentRepoImpl(StudentRepoImpl studentRepoImpl) {
		this.studentRepoImpl = studentRepoImpl;
	}

	@Override
	public void saveStudentService(Student student) {
		studentRepoImpl.saveStudentRepo(student);
		
	}

	@Override
	public Student selectStudentByIdService(int studentId) {
		Student std = studentRepoImpl.selectStudentByIdRepo(studentId);
		return std;
	}

	@Override
	public List<Student> selectallStudentsService() {
		List<Student> stdlist= studentRepoImpl.selectallStudentsRepo();
		return stdlist;
	}

	@Override
	public void deleteStudentByIdService(int studentId) {
		studentRepoImpl.deleteStudentByIdRepo(studentId);
		
	}

	@Override
	public void updateStudentService(Student student) {
		studentRepoImpl.updateStudentRepo(student);
		
	}

}
