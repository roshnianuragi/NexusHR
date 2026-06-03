package com.nexus.hr.specification;

import org.springframework.data.jpa.domain.Specification;

import com.nexus.hr.model.Employee;

public class EmployeeSpecification {

	// NAME FILTER

	public static Specification<Employee> hasName(String name) {

		return (root, query, cb) ->

		name == null ? null
				: cb.or(

						cb.like(cb.lower(root.get("firstName")), "%" + name.toLowerCase() + "%"),

						cb.like(cb.lower(root.get("lastName")), "%" + name.toLowerCase() + "%"));
	}

	// DESIGNATION FILTER

	public static Specification<Employee> hasDesignation(String designation) {

		return (root, query, cb) ->

		designation == null ? null : cb.equal(root.get("designation"), designation);
	}

	// DEPARTMENT FILTER

	public static Specification<Employee> hasDepartment(Long departmentId) {

		return (root, query, cb) ->

		departmentId == null ? null : cb.equal(root.get("department").get("id"), departmentId);
	}

	// MIN SALARY

	public static Specification<Employee> hasMinSalary(Double minSalary) {

		return (root, query, cb) ->

		minSalary == null ? null : cb.greaterThanOrEqualTo(root.get("salary"), minSalary);
	}

	// MAX SALARY

	public static Specification<Employee> hasMaxSalary(Double maxSalary) {

		return (root, query, cb) ->

		maxSalary == null ? null : cb.lessThanOrEqualTo(root.get("salary"), maxSalary);
	}
}