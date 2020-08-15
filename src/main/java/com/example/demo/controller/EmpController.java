package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EmpController {

	@Autowired
	private EmployeeService empService;
	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "View a Employee details")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/api/v1/employee/find/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Integer id) {
		return new ResponseEntity<>(empService.getEmployee(id), HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param employee
	 * @return
	 */
	@ApiOperation(value = "Persist Employee details")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully saved Employee details"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	
	@PutMapping("/api/v/employee/create")
	public ResponseEntity<Employee> saveEmployee( @RequestBody Employee employee) {
		return new ResponseEntity<>(empService.saveEmployee(employee), HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param employee
	 * @return
	 */
	@ApiOperation(value = "Updated Employee details")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated Employee details"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	
	@PostMapping("/api/v/employee/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<>(empService.updateEmployee(employee), HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "Deleted Employee details")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully deleted Employee details"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	
	@DeleteMapping("/api/v/employee/delete/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable("id") Integer id) {
		empService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
