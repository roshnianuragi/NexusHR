package com.nexus.hr.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexus.hr.model.EmployeeProfile;

public interface EmployeeProfileRepository extends JpaRepository<EmployeeProfile, Long> {

	// find profile by employee id
	Optional<EmployeeProfile> findByEmployeeId(Long employeeId);
}