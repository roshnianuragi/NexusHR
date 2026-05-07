package com.nexus.hr.service;

import com.nexus.hr.dto.EmployeeProfileDTO;

public interface EmployeeProfileService {

	EmployeeProfileDTO createOrUpdate(EmployeeProfileDTO dto);

	EmployeeProfileDTO getByEmployeeId(Long employeeId);
}