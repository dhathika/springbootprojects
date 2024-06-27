package com.rohan.hibernate1.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import com.rohan.hibernate1.pojo.Student;
@Repository
@EnableTransactionManagement
public class StudentRepoImpl implements StudentRepository{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	@Override
	public void saveStudentRepo(Student student) {
		hibernateTemplate.save(student);
		
	}

	@Override
	public Student selectStudentByIdRepo(int studentId) {
		Student student = hibernateTemplate.get(Student.class, studentId);
		return student;
	}

	@Override
	public List<Student> selectallStudentsRepo() {
		List<Student> stdlist = hibernateTemplate.loadAll(Student.class);
		return stdlist;
	}

	@Override
	public void deleteStudentByIdRepo(int studentId) {
		Student std = new Student();
		std.setSid(studentId);
		hibernateTemplate.delete(std);
	}

	@Override
	public void updateStudentRepo(Student student) {
		hibernateTemplate.saveOrUpdate(student);
		
	}

}
