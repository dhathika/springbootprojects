package com.rohan.hibernate.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.rohan.hibernate.pojo.Employee;

@Repository
@EnableTransactionManagement
public class EmployeeRepoImpl implements EmployeeRepository {
	
	
    @Autowired
	private HibernateTemplate hibernateTemplate;

	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	


	
    @Transactional
	public Employee selectEmployeeByIdRepo(int empId) {
		Employee employee = hibernateTemplate.get(Employee.class, empId);

		return employee;
	}
    @Transactional
	public void deleteEmployeeByIdRepo(int empId) {
		Employee emp = new Employee();
		emp.setEmpId(empId);
		hibernateTemplate.delete(emp);

	}
    @Transactional
	public List<Employee> selectAllEmployeesRepo() {
		List<Employee> employeeList = hibernateTemplate.loadAll(Employee.class);
		return employeeList;
	}
    @Transactional
	public void updateEmployeeRepo(Employee employee) {
		hibernateTemplate.saveOrUpdate(employee);

	}
    @Transactional
	@Override
	public void saveEmployeeRepo(Employee employee) {
		hibernateTemplate.save(employee);
		
	}
   
    
    }

