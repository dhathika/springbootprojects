package com.dhathika.first_springboot_demo.service;

import java.util.List;

import com.dhathika.first_springboot_demo.pojo.Employee;

public interface EmployeeService {
	
	public String saveEmployeeService(Employee employee);
	public Employee selectEmployeeByIdService(int empId);
	public List<Employee> selectAllEmployeeService();
	public String deleteEmployeeByIdService(int empId);
	public Employee updateEmployeeService(Employee employee);

}
