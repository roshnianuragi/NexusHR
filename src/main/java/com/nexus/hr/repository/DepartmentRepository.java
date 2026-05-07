package com.nexus.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nexus.hr.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	// search by name
	List<Department> findByNameContainingIgnoreCase(String name);

	// filter by location
	List<Department> findByLocation(String location);

	// active departments only
	List<Department> findByActiveTrue();
}