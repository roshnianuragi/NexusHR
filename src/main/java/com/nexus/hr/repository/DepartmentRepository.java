package com.nexus.hr.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nexus.hr.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	// SEARCH BY NAME

	List<Department> findByNameContainingIgnoreCase(String name);

	// FILTER BY LOCATION

	List<Department> findByLocationContainingIgnoreCase(String location);

	// ACTIVE DEPARTMENTS

	List<Department> findByActiveTrue();

	// PAGINATION + SEARCH

	Page<Department> findByNameContainingIgnoreCase(String name, Pageable pageable);

	Page<Department> findByLocationContainingIgnoreCase(String location, Pageable pageable);

	// COUNT ACTIVE

	long countByActiveTrue();
}