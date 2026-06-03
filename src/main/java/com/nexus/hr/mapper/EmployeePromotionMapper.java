package com.nexus.hr.mapper;

import com.nexus.hr.dto.EmployeePromotionDTO;
import com.nexus.hr.model.Employee;
import com.nexus.hr.model.EmployeePromotionHistory;

public class EmployeePromotionMapper {

	// DTO → ENTITY

	public static EmployeePromotionHistory mapToEntity(

			EmployeePromotionDTO dto,

			Employee employee) {

		EmployeePromotionHistory history = new EmployeePromotionHistory();

		history.setEmployee(employee);

		history.setOldDesignation(dto.getOldDesignation());

		history.setOldSalary(dto.getOldSalary());

		history.setNewDesignation(dto.getNewDesignation());

		history.setNewSalary(dto.getNewSalary());

		history.setReason(dto.getReason());

		history.setPromotionDate(dto.getPromotionDate());

		return history;
	}

	// ENTITY → DTO

	public static EmployeePromotionDTO mapToDTO(

			EmployeePromotionHistory history) {

		EmployeePromotionDTO dto = new EmployeePromotionDTO();

		dto.setEmployeeId(history.getEmployee().getId());

		dto.setOldDesignation(history.getOldDesignation());

		dto.setOldSalary(history.getOldSalary());

		dto.setNewDesignation(history.getNewDesignation());

		dto.setNewSalary(history.getNewSalary());

		dto.setReason(history.getReason());

		dto.setPromotionDate(history.getPromotionDate());

		return dto;
	}
}