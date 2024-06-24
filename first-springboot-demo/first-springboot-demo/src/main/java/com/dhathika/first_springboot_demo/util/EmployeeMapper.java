package com.dhathika.first_springboot_demo.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dhathika.first_springboot_demo.pojo.Employee;

public class EmployeeMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee emp = new Employee();
		emp.setEid(rs.getInt(1));
		emp.setEname(rs.getString(2));
		emp.setSalary(rs.getDouble(3));
		return emp;
	}

}
