package com.Ems.Emsbackend.Mapper;




import com.Ems.Emsbackend.dto.EmployeeDto;
import com.Ems.Emsbackend.entity.Employee;

public class EmployeeMapper {

//	mapping Employee Entity to EmployeeDto
	public static EmployeeDto mapToEmployeeDto(Employee employee) {

		return new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail());

	}
//	Mapping Employee Dto to Employee Entity

	public static Employee mapEmployeeEntity(EmployeeDto employeeDto) {
		return new Employee(
				employeeDto.getId(),
				employeeDto.getFirstName(),
				employeeDto.getLastName(),
				employeeDto.getEmail()
				
				);
	}

}
