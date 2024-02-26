package com.Ems.Emsbackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Ems.Emsbackend.dto.EmployeeDto;
import com.Ems.Emsbackend.service.EmployeeService;

import lombok.AllArgsConstructor;
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private EmployeeService employeeService;

//	build add Employee RestApi
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping("/post")

	public EmployeeDto createEmployee(@RequestBody EmployeeDto emplydto) {
		EmployeeDto savedEmployee = employeeService.createEmployee(emplydto);
		return savedEmployee;

	}

//	 get Employee by id
	@GetMapping("/employee/{id}")
	public EmployeeDto getEmployee(@PathVariable Long id) {
		return this.employeeService.getEmployeeById(id);
	}

//	Get All Employees 

	@GetMapping("/all")

	public ResponseEntity<List<EmployeeDto>> getAllEmployee() {
		List<EmployeeDto> employees = employeeService.getAllEmployee();
		return ResponseEntity.ok(employees);
	}

//	public ResponseEntity<EmployeeDto> updateEmployee (@PathVariable Long id,@RequestBody EmployeeDto updatedEmployee){
//		 EmployeeDto emplydto= employeeService.updateEmployee(id, updatedEmployee);
//		 return ResponseEntity.ok(emplydto);
//	}
	@ResponseStatus(value = HttpStatus.OK)
	@PutMapping(value = "update/{id}")

	public EmployeeDto updatedEmployee(@PathVariable Long id, @RequestBody EmployeeDto updteEmployee) {
		EmployeeDto employee = employeeService.updateEmployee(id, updteEmployee);
		return employee;
	}

	@ResponseStatus(value = HttpStatus.OK)
	@DeleteMapping("/delete/{id}")

	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return "Employee Delete Successffully";
	}

}
