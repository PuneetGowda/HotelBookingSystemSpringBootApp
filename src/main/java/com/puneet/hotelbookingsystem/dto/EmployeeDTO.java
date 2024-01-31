package com.puneet.hotelbookingsystem.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

// This class is a DTO to transfer list of employees of a hotel
public class EmployeeDTO {

	// Define the fields
	private int employee_id;
	
	private String employee_name;
	
	private float employee_salary;
	
	private long employee_phone;
	
	private String employee_email;
	
	private String employee_address;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	private Date employee_joining_date;

	// Generate getters and setters
	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public float getEmployee_salary() {
		return employee_salary;
	}

	public void setEmployee_salary(float employee_salary) {
		this.employee_salary = employee_salary;
	}

	public long getEmployee_phone() {
		return employee_phone;
	}

	public void setEmployee_phone(long employee_phone) {
		this.employee_phone = employee_phone;
	}

	public String getEmployee_email() {
		return employee_email;
	}

	public void setEmployee_email(String employee_email) {
		this.employee_email = employee_email;
	}

	public String getEmployee_address() {
		return employee_address;
	}

	public void setEmployee_address(String employee_address) {
		this.employee_address = employee_address;
	}

	public Date getEmployee_joining_date() {
		return employee_joining_date;
	}

	public void setEmployee_joining_date(Date employee_joining_date) {
		this.employee_joining_date = employee_joining_date;
	}

	// Generate toString method
	@Override
	public String toString() {
		return "EmployeeDTO [employee_id=" + employee_id + ", employee_name=" + employee_name + ", employee_salary="
				+ employee_salary + ", employee_phone=" + employee_phone + ", employee_email=" + employee_email
				+ ", employee_address=" + employee_address + ", employee_joining_date=" + employee_joining_date + "]";
	}
	
	
}
