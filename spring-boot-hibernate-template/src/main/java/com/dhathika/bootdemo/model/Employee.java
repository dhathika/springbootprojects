package com.dhathika.bootdemo.model;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Employee_Details1")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Employee_Id")
	private int empId;
	@Column(name = "Employee_Name")
	private String empName;
	@Column(name = "Employee_Gender")
	private String gender;
	@Column(name = "Employee_isMarried")
	private boolean isMarried;
	@Column(name = "Employee_Salary")
	private double empSalary;
	@Column(name = "Employee_Contact")
	private long empContact;
	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	public long getEmpContact() {
		return empContact;
	}
	public void setEmpContact(long empContact) {
		this.empContact = empContact;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	public boolean isMarried() {
		return isMarried;
	}
	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", gender=" + gender + ", isMarried=" + isMarried
				+ ", empSalary=" + empSalary + ", empContact=" + empContact + "]";
	}
	
	
}
