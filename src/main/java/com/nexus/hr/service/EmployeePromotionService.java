package com.nexus.hr.service;

import java.util.List;

import com.nexus.hr.dto.EmployeePromotionDTO;

public interface EmployeePromotionService {

	// PROMOTE EMPLOYEE

	EmployeePromotionDTO promoteEmployee(

			Long employeeId,

			EmployeePromotionDTO dto);

	// GET PROMOTION HISTORY

	List<EmployeePromotionDTO> getPromotionHistory(Long employeeId);
}