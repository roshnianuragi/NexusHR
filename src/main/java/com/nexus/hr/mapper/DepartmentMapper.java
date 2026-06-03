package com.nexus.hr.mapper;

import com.nexus.hr.dto.DepartmentDTO;
import com.nexus.hr.model.Department;

public class DepartmentMapper {

	// DTO → ENTITY

	public static Department mapToEntity(DepartmentDTO dto) {

		Department dept = new Department();

		dept.setId(dto.getId());

		dept.setName(dto.getName());

		dept.setLocation(dto.getLocation());

		dept.setBudget(dto.getBudget());

		dept.setDescription(dto.getDescription());

		dept.setHeadOfDepartment(dto.getHeadOfDepartment());

		dept.setActive(dto.isActive());

		// AUDIT FIELDS

		dept.setCreatedAt(dto.getCreatedAt());

		dept.setUpdatedAt(dto.getUpdatedAt());

		return dept;
	}

	// ENTITY → DTO

	public static DepartmentDTO mapToDTO(Department dept) {

		DepartmentDTO dto = new DepartmentDTO();

		dto.setId(dept.getId());

		dto.setName(dept.getName());

		dto.setLocation(dept.getLocation());

		dto.setBudget(dept.getBudget());

		dto.setDescription(dept.getDescription());

		dto.setHeadOfDepartment(dept.getHeadOfDepartment());

		dto.setActive(dept.isActive());

		// AUDIT FIELDS

		dto.setCreatedAt(dept.getCreatedAt());

		dto.setUpdatedAt(dept.getUpdatedAt());

		return dto;
	}
}