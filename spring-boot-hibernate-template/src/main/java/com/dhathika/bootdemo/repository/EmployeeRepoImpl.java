package com.dhathika.bootdemo.repository;

import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.dhathika.bootdemo.model.Employee;

@Repository
@EnableTransactionManagement
public class EmployeeRepoImpl implements EmployeeRepository {
	static Logger log = Logger.getLogger("EmployeeRepoImpl");
	
    @Autowired
	private HibernateTemplate hibernateTemplate;

	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

    @Transactional
	public void saveEmployeeRepo(Employee employee) {
    	log.info(employee.getEmpId() +" Tranction entry into EmployeeRepositoryclass saveEmployee()");
		hibernateTemplate.save(employee);
		log.info(employee.getEmpId() +" Tranction entry Exit EmployeeRepositoryclass saveEmployee()");

	}
    @Transactional
	public Employee selectEmployeeByIdRepo(int empId) {
    	log.info(" Tranction entry into EmployeeRepositoryclass selectEmployeeByIdRepo()");
		Employee employee = hibernateTemplate.get(Employee.class, empId);
		log.info(" Tranction Exit into EmployeeRepositoryclass selectEmployeeByIdRepo()");
		return employee;
	   	
	}
    @Transactional
	public void deleteEmployeeByIdRepo(int empId) {
    	log.info(" Tranction Entry into EmployeeRepositoryclass deleteEmployeeByIdRepo()");
		Employee emp = new Employee();
		emp.setEmpId(empId);
		hibernateTemplate.delete(emp);
		log.info(" Tranction exit from EmployeeRepositoryclass deleteEmployeeByIdRepo()");
	}
    @Transactional
	public List<Employee> selectAllEmployeesRepo() {
    	log.info(" Tranction Entry into EmployeeRepositoryclass selectAllEmployeesRepo()");
		List<Employee> employeeList = hibernateTemplate.loadAll(Employee.class);
		log.info(" Tranction exit from EmployeeRepositoryclass selectAllEmployeesRepo()");
		return employeeList;
	}
    @Transactional
	public void updateEmployeeRepo(Employee employee) {
    	log.info(" Tranction Entry into EmployeeRepositoryclass updateEmployeeRepo()");
		hibernateTemplate.saveOrUpdate(employee);
		log.info(" Tranction Exit from EmployeeRepositoryclass updateEmployeeRepo()");
	}

}
