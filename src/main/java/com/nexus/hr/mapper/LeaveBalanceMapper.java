package com.nexus.hr.mapper;

import com.nexus.hr.dto.LeaveBalanceDTO;
import com.nexus.hr.model.Employee;
import com.nexus.hr.model.LeaveBalance;

public class LeaveBalanceMapper {

	public static LeaveBalance mapToEntity(LeaveBalanceDTO dto, Employee emp) {

		LeaveBalance lb = new LeaveBalance();

		lb.setId(dto.getId()); // safe for update
		lb.setTotalCL(dto.getTotalCL());
		lb.setUsedCL(dto.getUsedCL());
		lb.setTotalPL(dto.getTotalPL());
		lb.setUsedPL(dto.getUsedPL());
		lb.setEmployee(emp);

		return lb;
	}

	public static LeaveBalanceDTO mapToDTO(LeaveBalance lb) {

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