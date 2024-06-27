package com.rohan.hibernate.service1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.rohan.hibernate.pojo.Employee;
import com.rohan.hibernate.repo.EmployeeRepoImpl;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepoImpl employeeRepoImpl;

	@Override
	public void saveEmployeeService(Employee employee) {
		if(employee.getEmpSalary()<20000) {
			double hike = employee.getEmpSalary() * 0.1;
			double hikeSalary = employee.getEmpSalary() + hike;
			employee.setEmpSalary(hikeSalary);
		}
		 employeeRepoImpl.saveEmployeeRepo(employee);
		
	}

	@Override
	public Employee selectEmployeeByIdService(int empId) {
		Employee emp = employeeRepoImpl.selectEmployeeByIdRepo(empId);
		return emp;
	}

	

	@Override
	public void deleteEmployeeByIdService(int empId) {
		 employeeRepoImpl.deleteEmployeeByIdRepo(empId);
		
	}

	@Override
	public void updateEmployeeService(Employee employee) {
		  employeeRepoImpl.updateEmployeeRepo(employee);
		
	}

	@Override
	public List<Employee> selectAllEmployeesService() {
		List<Employee> list = employeeRepoImpl.selectAllEmployeesRepo();
		return list;
	}

	

}
