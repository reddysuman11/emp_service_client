package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repositry.EmpRepositry;

@Service
public class EmpServiceImpl implements EmployeeService {

	@Autowired
	private EmpRepositry empRepositry;
	
	@Override
	public Employee getEmployee(Integer id) {
		
		Optional<com.example.demo.entity.Employee> emp = empRepositry.findById(id);
		Employee empTarget = null;
		
		if (emp.isPresent()) {
			empTarget = new Employee();
			BeanUtils.copyProperties(emp.get(), empTarget);
		}
		
		return empTarget;
	}
	
	@Override
	public Employee saveEmployee(Employee employee) {
		
		com.example.demo.entity.Employee empEntity = new com.example.demo.entity.Employee();
		
		BeanUtils.copyProperties(employee, empEntity);
		
		empRepositry.save(empEntity);
		
		return employee;
		
	}
	
	@Override
	public Employee updateEmployee(Employee employee) {

		com.example.demo.entity.Employee empEntity = empRepositry.findById(employee.getId()).orElse(new com.example.demo.entity.Employee());
		
		if (employee.getName() != null) {
			empEntity.setName(employee.getName());
		}	
		
		if (employee.getSection() != null) {
			empEntity.setSection(employee.getSection());
		}
		
		BeanUtils.copyProperties(empRepositry.save(empEntity), employee);
		
		return employee;
	}
	
	@Override
	public void deleteEmployee(Integer id) {
		empRepositry.deleteById(id);
	}
}
