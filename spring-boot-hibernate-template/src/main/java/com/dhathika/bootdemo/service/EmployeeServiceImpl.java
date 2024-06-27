package com.dhathika.bootdemo.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhathika.bootdemo.model.Employee;
import com.dhathika.bootdemo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	static Logger log = Logger.getLogger("EmployeeServiceImpl");
    @Autowired
	private EmployeeRepository employeeRepository;

	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public void saveEmployeeService(Employee employee) {
     	log.info(employee.getEmpId() + " Tranction Entry into EmployeeServiceImpl saveEmployeeService()");
		try {
			deductEmployeeTax(employee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.warning(e.getMessage());
		}
		setTitlesToEmplyee(employee);
		employeeRepository.saveEmployeeRepo(employee);
		log.info(employee.getEmpId() + " Tranction exit from EmployeeServiceImpl saveEmployeeService()");
	}

	private void setTitlesToEmplyee(Employee employee) {
		log.info(employee.getEmpId() + " Tranction Entry into EmployeeServiceImpl setTitlesToEmplyee()");
		if (employee.getGender().equalsIgnoreCase("male")) {
			employee.setEmpName("Mr." + employee.getEmpName());
		} else if (employee.getGender().equalsIgnoreCase("female") && employee.isMarried()) {
			employee.setEmpName("Smt " + employee.getEmpName());
		} else {
			employee.setEmpName("Miss " + employee.getEmpName());
		}
		log.info(employee.getEmpId() +" Tranction Exit from EmployeeServiceImpl setTitlesToEmplyee()");
	}

	public void deductEmployeeTax(Employee employee) throws Exception  {
		log.info(employee.getEmpId() +" Tranction Entry into EmployeeServiceImpl deductEmployeeTax()");
    	 if (employee.getEmpSalary() < 20000) {
    		 throw new Exception("Minimum wages in India is 36000");
 			
 		}
    	 if (employee.getEmpSalary() < 500000) {
			System.out.println(employee.getEmpId() +"Employee is under tax excemption");
		}
		if (employee.getEmpSalary() >= 500000 && employee.getEmpSalary() <= 1000000) {
			double tax = (employee.getEmpSalary() * 0.15);
			double employeeSalaryAfterDeduction = employee.getEmpSalary() - tax;
			employee.setEmpSalary(employeeSalaryAfterDeduction);
		}
		if (employee.getEmpSalary() > 1000000 && employee.getEmpSalary() <= 2000000) {
			double tax = (employee.getEmpSalary() * 0.2);
			double employeeSalaryAfterDeduction = employee.getEmpSalary() - tax;
			employee.setEmpSalary(employeeSalaryAfterDeduction);
		}
		if (employee.getEmpSalary() > 2000000) {
			double tax = (employee.getEmpSalary() * 0.35);
			double employeeSalaryAfterDeduction = employee.getEmpSalary() - tax;
			employee.setEmpSalary(employeeSalaryAfterDeduction);
		}
		log.info(employee.getEmpId() +" Tranction Exit from EmployeeServiceImpl deductEmployeeTax()");
		
	}

	public Employee selectEmployeeByIdService(int empId) {
		log.info(empId +" Tranction Entry into EmployeeServiceImpl selectEmployeeByIdService()");
	  Employee selectedEmployee = employeeRepository.selectEmployeeByIdRepo(empId);
	  log.info(empId + " Tranction exit from EmployeeServiceImpl selectEmployeeByIdService()");
	  return selectedEmployee;
	}

	public void deleteEmployeeByIdService(int empId) {
		log.info(empId +" Tranction Entry into EmployeeServiceImpl deleteEmployeeByIdService()");
		employeeRepository.deleteEmployeeByIdRepo(empId);
		log.info(empId + " Tranction Exit from EmployeeServiceImpl deleteEmployeeByIdService()");
	}

	public List<Employee> selectAllEmployeesService() {
		log.info(" Tranction Entry into EmployeeServiceImpl selectAllEmployeesService()");
	List<Employee> empList = employeeRepository.selectAllEmployeesRepo();
	log.info(" Tranction exit from EmployeeServiceImpl selectAllEmployeesService()");
		return empList;
	}

	public void updateEmployeeService(Employee employee) throws Exception {
		 System.out.println(employee.getEmpId() +" Tranction Entry into EmployeeServiceImpl updateEmployeeService()");
		deductEmployeeTax(employee);
		setTitlesToEmplyee(employee);
		employeeRepository.updateEmployeeRepo(employee);
		 System.out.println(employee.getEmpId() +" Tranction Exit from EmployeeServiceImpl updateEmployeeService()");

	}

}
