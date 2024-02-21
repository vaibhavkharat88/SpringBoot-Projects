package com.RestApiCrudProject.RestApiCrudProject.Mycontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.RestApiCrudProject.RestApiCrudProject.Employee.Employee;

@RestController

public class Mycontroller {
	
	@GetMapping("/getdata")
	public Employee myEmployee() {
		Employee emp=new Employee(55,"sai","Pachora");
//		Employee Employee=new Employee();
		
		
		return emp;
	}
	@PostMapping(value="/post",
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.CREATED) 
	public Employee PostEmployee(@RequestBody Employee employee ) {
		System.out.println(employee.getId());
		System.out.println(employee.getName());
		return employee;
	}
	@PutMapping(value="/update/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public Employee updateEmployee(@PathVariable int id,@RequestBody Employee  updateEmployee ) {
		System.out.println(id);
		System.out.println(updateEmployee.getName());
		System.out.println(updateEmployee.getAdddress());
		updateEmployee.setId(id);
		return updateEmployee;
	}
	@ResponseStatus(value=HttpStatus.OK)
	@DeleteMapping(value="/delete/{id}")
	public void deleteEmployee(@PathVariable int id) {
		System.out.println(id);
		System.out.println("data succesfully deleted");
		
	}
	

}
