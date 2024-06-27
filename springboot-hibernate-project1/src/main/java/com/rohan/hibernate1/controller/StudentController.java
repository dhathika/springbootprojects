package com.rohan.hibernate1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rohan.hibernate1.pojo.Student;
import com.rohan.hibernate1.service.StudentServiceImpl;


@RestController
public class StudentController {
	@Autowired
	StudentServiceImpl studentServiceImpl;
	
	@PostMapping("/student/newstudent")
	public void saveStudentController(@RequestBody Student student) {
		studentServiceImpl.saveStudentService(student);
	}
	
	@GetMapping("/getstudent/{stdid}")
	public Student getStudentById(@PathVariable("stdid") int studentid) {
		Student selectedstudent = studentServiceImpl.selectStudentByIdService(studentid);
		return selectedstudent;
	}
	@GetMapping("/getallstudents")
	public List<Student> selectAllStudent(){
		List<Student> stdList = studentServiceImpl.selectallStudentsService();
		return stdList;
	}
	@DeleteMapping("/deletestudent/{stdId}")
	public void deleteStudentById(@PathVariable("stdId") int stdid) {
		studentServiceImpl.deleteStudentByIdService(stdid);
		
	}
	
	@PutMapping("/updatestudent")
	public void updatestudentById(@RequestBody Student student) {
		Student studentToUpdate = new Student();
		studentToUpdate.setSid(student.getSid());
		List<Student> stdList = selectAllStudent();
		for(Student std : stdList) {
			if(std.getSid()==student.getSid()) {
				if(!std.getSname().equals(student.getSname())) {
					studentToUpdate.setSname(student.getSname());
				}
			if(std.getMarks()!=student.getMarks())
				studentToUpdate.setMarks(student.getMarks());
			}
		}
		studentServiceImpl.updateStudentService(studentToUpdate);
	
	}
	
}
