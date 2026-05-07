package com.nexus.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexus.hr.model.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

	// all assignments of employee
	List<Assignment> findByEmployeeId(Long employeeId);

	// all assignments of project
	List<Assignment> findByProjectId(Long projectId);

	// filter by role
	List<Assignment> findByRole(String role);
}