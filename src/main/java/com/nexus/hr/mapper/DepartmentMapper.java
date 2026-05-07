package com.nexus.hr.mapper;

import com.nexus.hr.dto.DepartmentDTO;
import com.nexus.hr.model.Department;

public class DepartmentMapper {

	// DTO → Entity
	public static Department mapToEntity(DepartmentDTO dto) {

		Department dept = new Department();

		dept.setId(dto.getId());
		dept.setName(dto.getName());
		dept.setLocation(dto.getLocation());
		dept.setBudget(dto.getBudget());
		dept.setHeadOfDepartment(dto.getHeadOfDepartment());
		dept.setActive(dto.isActive());

		return dept;
	}

	// Entity → DTO
	public static DepartmentDTO mapToDTO(Department dept) {

		DepartmentDTO dto = new DepartmentDTO();

		dto.setId(dept.getId());
		dto.setName(dept.getName());
		dto.setLocation(dept.getLocation());
		dto.setBudget(dept.getBudget());
		dto.setHeadOfDepartment(dept.getHeadOfDepartment());
		dto.setActive(dept.isActive());

		return dto;
	}
}