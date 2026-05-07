package com.nexus.hr.mapper;

import com.nexus.hr.dto.LeaveBalanceDTO;
import com.nexus.hr.model.Employee;
import com.nexus.hr.model.LeaveBalance;

public class LeaveBalanceMapper {

	// DTO → ENTITY
	public static LeaveBalance mapToEntity(LeaveBalanceDTO dto, Employee emp) {

		if (dto == null)
			return null;

		LeaveBalance lb = new LeaveBalance();

		lb.setId(dto.getId());
		lb.setTotalCL(dto.getTotalCL());
		lb.setUsedCL(dto.getUsedCL());
		lb.setTotalPL(dto.getTotalPL());
		lb.setUsedPL(dto.getUsedPL());

		lb.setEmployee(emp);

		return lb;
	}

	// ENTITY → DTO
	public static LeaveBalanceDTO mapToDTO(LeaveBalance lb) {

		if (lb == null)
			return null;

		LeaveBalanceDTO dto = new LeaveBalanceDTO();

		dto.setId(lb.getId());
		dto.setTotalCL(lb.getTotalCL());
		dto.setUsedCL(lb.getUsedCL());
		dto.setTotalPL(lb.getTotalPL());
		dto.setUsedPL(lb.getUsedPL());

		if (lb.getEmployee() != null) {
			dto.setEmployeeId(lb.getEmployee().getId());
		}

		return dto;
	}
}