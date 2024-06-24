package com.dhathika.first_springboot_demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dhathika.first_springboot_demo.pojo.Employee;
import com.dhathika.first_springboot_demo.util.EmployeeMapper;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public String saveEmployeeDao(Employee employee) {
		String insertEmployeeQuery = "insert into Employee values(" +employee.getEid() +
				",'" + employee.getEname() + "'," 
				 + employee.getSalary() + ")";
	jdbcTemplate.execute(insertEmployeeQuery);
		return "success";
	}

	@Override
	public Employee selectEmployeeByIdDao(int empId) {
	String selectQuery = "Select * from employee Where eid=" + empId;
	List<Employee> empList =  jdbcTemplate.query(selectQuery, new EmployeeMapper());
		return empList.get(0);
	}

	@Override
	public List<Employee> selectAllEmployeeDao() {
		String selectAllQuery = "select * from employee";
		List<Employee> empList = jdbcTemplate.query(selectAllQuery, new EmployeeMapper());
		return empList;
	}

	@Override
	public String deleteEmployeeByIdDao(int empId) {
		String deleteQuery = "delete from employee where eid=" + empId;
		jdbcTemplate.execute(deleteQuery);
		return "deleted successfully";
	}

	@Override
	public Employee updateEmployeeDao(Employee employee) {
		String updateQuery = "update employee set ename=" + "'" + employee.getEname() + "'," 
				+ "salary =" + employee.getSalary() + "where eid=" + employee.getEid();
		jdbcTemplate.execute(updateQuery);
		Employee updateEmployee = selectEmployeeByIdDao(employee.getEid());
		return updateEmployee;
	}

}
