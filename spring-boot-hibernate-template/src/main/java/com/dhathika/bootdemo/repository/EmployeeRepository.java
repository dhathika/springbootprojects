package com.dhathika.bootdemo.repository;

import java.util.List;

import com.dhathika.bootdemo.model.Employee;

public interface EmployeeRepository {
	
	public void saveEmployeeRepo(Employee employee);
	public Employee selectEmployeeByIdRepo(int empId);
	public void deleteEmployeeByIdRepo(int empId);
	public List<Employee> selectAllEmployeesRepo();
	public void updateEmployeeRepo(Employee employee);

}
