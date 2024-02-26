package com.Ems.Emsbackend.service;

import java.util.List;

import com.Ems.Emsbackend.dto.EmployeeDto;

public interface EmployeeService {
	EmployeeDto  createEmployee (EmployeeDto employeeDto) ;
	
	EmployeeDto getEmployeeById(Long id);
	
	List<EmployeeDto> getAllEmployee();
	
	EmployeeDto updateEmployee(Long id, EmployeeDto upatedatedEmployee);
	
	void deleteEmployee (Long id );
	
	

}
