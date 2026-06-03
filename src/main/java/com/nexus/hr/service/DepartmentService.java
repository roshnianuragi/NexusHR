package com.nexus.hr.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nexus.hr.dto.DepartmentDTO;

public interface DepartmentService {

	// CREATE
	DepartmentDTO createDepartment(DepartmentDTO dto);

	// GET BY ID
	DepartmentDTO getDepartmentById(Long id);

	// GET ALL
	List<DepartmentDTO> getAllDepartments();

	// PAGINATION
	Page<DepartmentDTO> getDepartments(Pageable pageable);

	// UPDATE
	DepartmentDTO updateDepartment(Long id, DepartmentDTO dto);

	// DELETE
	void deleteDepartment(Long id);

	// GET EMPLOYEES
	List<?> getEmployeesByDepartment(Long departmentId);

	// SEARCH
	List<DepartmentDTO> searchByName(String name);

	List<DepartmentDTO> searchByLocation(String location);

	// ACTIVE DEPARTMENTS
	List<DepartmentDTO> getActiveDepartments();

	// BULK SALARY RAISE
	void raiseDepartmentSalary(Long departmentId, double percentage);

	// ANALYTICS
	long getTotalEmployees(Long departmentId);

	double getTotalSalary(Long departmentId);

	String getGenderRatio(Long departmentId);
}