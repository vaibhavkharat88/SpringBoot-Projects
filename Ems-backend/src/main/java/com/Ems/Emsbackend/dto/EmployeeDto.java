package com.Ems.Emsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//we use this section for mapping employee to employee dto and  employee dto  to employee entity ;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
}
