package com.rohan.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rohan.hibernate.pojo.Employee;
import com.rohan.hibernate.service1.EmployeeServiceImpl;



@RestController
public class EmployeeController {
	@Autowired
	EmployeeServiceImpl employeeServiceImpl;
	
	@PostMapping("/employee/newemployee")
	public void saveEmployeeController(@RequestBody Employee employee) {
		employeeServiceImpl.saveEmployeeService(employee);
	}
	@GetMapping("/getemployee/{empid}")
	public Employee getEmployeeById(@PathVariable("empid") int empid) {
		Employee selectedEmployee = employeeServiceImpl.selectEmployeeByIdService(empid);
		return selectedEmployee;
	}
	@GetMapping("/getallemployees")
	public List<Employee> selectAllEmployee(){
		List<Employee> empList = employeeServiceImpl.selectAllEmployeesService();
		return empList;
	}
	@DeleteMapping("/deleteemployee/{empId}")
	public void deleteEmployeeById(@PathVariable("empId") int id) {
		 employeeServiceImpl.deleteEmployeeByIdService(id);
		
	}
	@PutMapping("/updateemployee")
	public void updateEmployeeById(@RequestBody Employee employee) {
		Employee empToUpdate = new Employee();
		empToUpdate.setEmpId(employee.getEmpId());
		List<Employee> empList = selectAllEmployee();
		for(Employee emp : empList) {
			if(emp.getEmpId()==employee.getEmpId()) {
				if(!emp.getEmpName().equals(employee.getEmpName())) {
					empToUpdate.setEmpName(employee.getEmpName());
				}
			if(emp.getEmpSalary()!=employee.getEmpSalary())
				empToUpdate.setEmpSalary(employee.getEmpSalary());
			}
		}
	 	employeeServiceImpl.updateEmployeeService(empToUpdate);
	
	}
		

}