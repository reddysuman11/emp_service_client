package com.example.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;

@Repository
public interface EmpRepositry  extends JpaRepository<Employee, Integer>, CrudRepository<Employee, Integer> {

}
