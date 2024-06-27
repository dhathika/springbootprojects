package com.dhathika.bootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.dhathika.bootdemo.model.Employee;
import com.dhathika.bootdemo.service.EmployeeServiceImpl;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeServiceImpl serviceImpl;
	
	@PostMapping("/addemployee")
	public String saveEmployee(@RequestBody Employee employee) {
		serviceImpl.saveEmployeeService(employee);
		return "success";
	}

}
