package com.nexus.hr.mapper;

import com.nexus.hr.dto.EmployeeTransferDTO;
import com.nexus.hr.model.Department;
import com.nexus.hr.model.Employee;
import com.nexus.hr.model.EmployeeTransferHistory;

public class EmployeeTransferMapper {

	// DTO → ENTITY
	public static EmployeeTransferHistory mapToEntity(EmployeeTransferDTO dto, Employee employee,
			Department oldDepartment, Department newDepartment) {

		EmployeeTransferHistory history = new EmployeeTransferHistory();

		history.setEmployee(employee);
		history.setOldDepartment(oldDepartment);
		history.setNewDepartment(newDepartment);

		history.setReason(dto.getReason());

		// SAFE handling
		if (dto.getTransferDate() != null) {
			history.setTransferDate(dto.getTransferDate());
		}

		return history;
	}

	// ENTITY → DTO
	public static EmployeeTransferDTO mapToDTO(EmployeeTransferHistory history) {

		EmployeeTransferDTO dto = new EmployeeTransferDTO();

		// SAFE NULL CHECKS (VERY IMPORTANT)
		if (history.getEmployee() != null) {
			dto.setEmployeeId(history.getEmployee().getId());
		}

		if (history.getOldDepartment() != null) {
			dto.setOldDepartmentId(history.getOldDepartment().getId());
		}

		if (history.getNewDepartment() != null) {
			dto.setNewDepartmentId(history.getNewDepartment().getId());
		}

		dto.setReason(history.getReason());
		dto.setTransferDate(history.getTransferDate());

		return dto;
	}
}