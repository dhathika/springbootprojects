package com.dhathika.first_springboot_demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dhathika.first_springboot_demo.pojo.Employee;
import com.dhathika.first_springboot_demo.service.EmployeeServiceImpl;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeServiceImpl employeeServiceImpl;
	

	@PostMapping("/employee/newemployee")
	public String saveEmployeeController(@RequestBody Employee employee) {
	String response = 	employeeServiceImpl.saveEmployeeService(employee);
		return response;
	}
	@GetMapping("/getemployee/{empid}")
	public Employee getEmployeeById(@PathVariable("empid") int empid) {
		Employee selectedEmployee = employeeServiceImpl.selectEmployeeByIdService(empid);
		return selectedEmployee;
	}
	@GetMapping("/getallemployees")
	public List<Employee> selectAllEmployee(){
		List<Employee> empList = employeeServiceImpl.selectAllEmployeeService();
		return empList;
	}
	@DeleteMapping("/deleteemployee/{empId}")
	public String deleteEmployeeById(@PathVariable("empId") int id) {
		String result = employeeServiceImpl.deleteEmployeeByIdService(id);
		return result;
	}
	@PutMapping("/updateemployee")
	public Employee updateEmployeeById(@RequestBody Employee employee) {
		Employee empToUpdate = new Employee();
		empToUpdate.setEid(employee.getEid());
		List<Employee> empList = selectAllEmployee();
		for(Employee emp : empList) {
			if(emp.getEid()==employee.getEid()) {
				if(!emp.getEname().equals(employee.getEname())) {
					empToUpdate.setEname(employee.getEname());
				}
			if(emp.getSalary()!=employee.getSalary())
				empToUpdate.setSalary(employee.getSalary());
			}
		}
	Employee emp = 	employeeServiceImpl.updateEmployeeService(empToUpdate);
	return emp;
	}

}
