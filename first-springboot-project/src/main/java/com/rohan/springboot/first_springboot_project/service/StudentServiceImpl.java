package com.rohan.springboot.first_springboot_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohan.springboot.first_springboot_project.pojo.Student;
import com.rohan.springboot.first_springboot_project.repository.StudentRepoImpl;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepoImpl studentRepoImpl;

	@Override
	public void saveStudentService(Student student) {
		studentRepoImpl.saveStudentRepo(student);
		
	}

	@Override
	public Student selectStudentByIdService(int studentId) {
		Student student = studentRepoImpl.selectStudentByIdRepo(studentId);
		return student;
	}

	@Override
	public List<Student> selectallStudentsService() {
		List<Student> stdlist = studentRepoImpl.selectallStudentsRepo();
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
