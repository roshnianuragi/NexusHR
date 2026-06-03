package com.nexus.hr.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nexus.hr.dto.EmployeeDTO;

public interface EmployeeService {

	// CRUD
	EmployeeDTO createEmployee(EmployeeDTO dto);

	EmployeeDTO getEmployeeById(Long id);

	List<EmployeeDTO> getAllEmployees();

	EmployeeDTO updateEmployee(Long id, EmployeeDTO dto);

	void deleteEmployee(Long id);

	// PAGINATION
	Page<EmployeeDTO> getEmployees(Pageable pageable);

	// ADVANCED METHODS
	EmployeeDTO getEmployeeByEmail(String email);

	List<EmployeeDTO> getEmployeesByDepartment(Long departmentId);

	List<EmployeeDTO> getEmployeesByDesignation(String designation);

	List<EmployeeDTO> searchEmployees(String name);

	long countEmployeesByDepartment(Long departmentId);

	Page<EmployeeDTO> searchEmployees(String name, Long departmentId, String designation, Double minSalary,
			Double maxSalary, Pageable pageable);
}