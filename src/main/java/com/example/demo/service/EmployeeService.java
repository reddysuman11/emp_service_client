package com.example.demo.service;

import com.example.demo.model.Employee;

public interface EmployeeService {

	public Employee getEmployee(Integer id) ;
	
	public Employee saveEmployee(Employee employee) ;
	
	public Employee updateEmployee(Employee employee);	
	
	public void deleteEmployee(Integer id) ;
}
