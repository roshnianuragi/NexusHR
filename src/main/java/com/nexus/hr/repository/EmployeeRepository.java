package com.nexus.hr.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.nexus.hr.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {

	// find by email
	Optional<Employee> findByEmail(String email);

	// find by department
	List<Employee> findByDepartmentId(Long departmentId);

	// search by name (partial match)
	List<Employee> findByFirstNameContainingIgnoreCase(String name);

	// count employees in department
	long countByDepartmentId(Long departmentId);

	// find by designation (e.g. Developer, Manager)
	List<Employee> findByDesignation(String designation);

	// find employees with salary greater than value
	List<Employee> findBySalaryGreaterThan(double salary);

	// find employees in salary range
	List<Employee> findBySalaryBetween(double min, double max);

	// search by first OR last name (flexible search)
	List<Employee> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName);

	// department + designation filter
	List<Employee> findByDepartmentIdAndDesignation(Long departmentId, String designation);

}
