package com.Ems.Emsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ems.Emsbackend.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	

}
