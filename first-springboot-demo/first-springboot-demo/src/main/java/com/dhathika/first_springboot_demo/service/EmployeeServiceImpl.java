package com.dhathika.first_springboot_demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhathika.first_springboot_demo.pojo.Employee;
import com.dhathika.first_springboot_demo.repository.EmployeeDaoImpl;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDaoImpl employeeDaoImpl;

	@Override
	public String saveEmployeeService(Employee employee) {
		if(employee.getSalary()<20000) {
			double hike = employee.getSalary() * 0.1;
			double hikeSalary = employee.getSalary() + hike;
			employee.setSalary(hikeSalary);
		}
		String response = employeeDaoImpl.saveEmployeeDao(employee);
		return response;
	}

	@Override
	public Employee selectEmployeeByIdService(int empId) {
		Employee emp = employeeDaoImpl.selectEmployeeByIdDao(empId);
		return emp;
	}

	@Override
	public List<Employee> selectAllEmployeeService() {
	List<Employee> empList =	employeeDaoImpl.selectAllEmployeeDao();
		return empList;
	}

	@Override
	public String deleteEmployeeByIdService(int empId) {
		String result = employeeDaoImpl.deleteEmployeeByIdDao(empId);
		return result;
	}

	@Override
	public Employee updateEmployeeService(Employee employee) {
		Employee emp = employeeDaoImpl.updateEmployeeDao(employee);
		return emp;
	}

}
