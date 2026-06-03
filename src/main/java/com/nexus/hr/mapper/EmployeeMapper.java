package com.nexus.hr.mapper;

import com.nexus.hr.dto.EmployeeDTO;
import com.nexus.hr.model.Department;
import com.nexus.hr.model.Employee;

public class EmployeeMapper {

	// DTO → ENTITY
	public static Employee mapToEntity(EmployeeDTO dto, Department dept) {

		Employee emp = new Employee();

		emp.setId(dto.getId());

		emp.setFirstName(dto.getFirstName());

		emp.setLastName(dto.getLastName());

		emp.setEmail(dto.getEmail());

		emp.setPhone(dto.getPhone());

		emp.setAge(dto.getAge());

		// ✅ NEW FIELD
		emp.setGender(dto.getGender());

		emp.setSalary(dto.getSalary());

		emp.setDesignation(dto.getDesignation());

		emp.setDepartment(dept);

		return emp;
	}

	// ENTITY → DTO
	public static EmployeeDTO mapToDTO(Employee emp) {

		EmployeeDTO dto = new EmployeeDTO();

		dto.setId(emp.getId());

		dto.setFirstName(emp.getFirstName());

		dto.setLastName(emp.getLastName());

		dto.setEmail(emp.getEmail());

		dto.setPhone(emp.getPhone());

		dto.setAge(emp.getAge());

		// NEW FIELD
		dto.setGender(emp.getGender());

		dto.setSalary(emp.getSalary());

		dto.setDesignation(emp.getDesignation());

		// DEPARTMENT DETAILS
		if (emp.getDepartment() != null) {

			dto.setDepartmentId(emp.getDepartment().getId());

			// OPTIONAL
			dto.setDepartmentName(emp.getDepartment().getName());
		}

		return dto;
	}
}