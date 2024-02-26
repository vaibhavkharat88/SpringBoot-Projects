package com.Ems.Emsbackend.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


import com.Ems.Emsbackend.Mapper.EmployeeMapper;
import com.Ems.Emsbackend.dto.EmployeeDto;
import com.Ems.Emsbackend.entity.Employee;
import com.Ems.Emsbackend.exception.ResourceNotFoundException;
import com.Ems.Emsbackend.repository.EmployeeRepository;
import com.Ems.Emsbackend.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeImpl implements EmployeeService {

//	creating  object of EmployeeRepository from Repository Interface
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {

		Employee employee = EmployeeMapper.mapEmployeeEntity(employeeDto);
		Employee savedEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(Long id) {
		Employee employee = this.employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee Not found with given id " + id));
//		converting Employee Entity to dto
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		List<Employee> employees = employeeRepository.findAll();

		return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(Long id, EmployeeDto upatedatedEmployee) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee doesn't exist with given id"));
		employee.setFirstName(upatedatedEmployee.getFirstName());
		employee.setLastName(upatedatedEmployee.getLastName());
		employee.setEmail(upatedatedEmployee.getEmail());

		Employee updatedEmpobj = employeeRepository.save(employee);

		return EmployeeMapper.mapToEmployeeDto(updatedEmpobj);

	}

	@Override
	public void deleteEmployee(Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("id not exist " + id));

		employeeRepository.delete(employee);

	}

}
