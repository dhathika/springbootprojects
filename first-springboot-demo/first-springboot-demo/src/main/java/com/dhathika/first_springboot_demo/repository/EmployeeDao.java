package com.dhathika.first_springboot_demo.repository;

import java.util.List;

import com.dhathika.first_springboot_demo.pojo.Employee;

public interface EmployeeDao {
	
	public String saveEmployeeDao(Employee employee);
	public Employee selectEmployeeByIdDao(int empId);
	public List<Employee> selectAllEmployeeDao();
	public String deleteEmployeeByIdDao(int empId);
	public Employee updateEmployeeDao(Employee employee);

}
