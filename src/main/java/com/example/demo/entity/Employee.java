package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "employee")
public class Employee {

	@Id
	@Column( name = "eno")
	private Integer id;
	
	@Column(name = "ename")
	private String name;
	
	@Column(name = "esection")
	private String section;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	
	
}
