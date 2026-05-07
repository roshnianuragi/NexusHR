package com.nexus.hr.service;

import java.util.List;

import com.nexus.hr.dto.DepartmentDTO;

public interface DepartmentService {

	DepartmentDTO createDepartment(DepartmentDTO dto);

	DepartmentDTO getDepartmentById(Long id);

	List<DepartmentDTO> getAllDepartments();

	DepartmentDTO updateDepartment(Long id, DepartmentDTO dto);

	void deleteDepartment(Long id);

	List<?> getEmployeesByDepartment(Long departmentId);
}