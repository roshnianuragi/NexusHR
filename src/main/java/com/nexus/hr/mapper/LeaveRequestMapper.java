package com.nexus.hr.mapper;

import com.nexus.hr.dto.LeaveRequestDTO;
import com.nexus.hr.enums.LeaveStatus;
import com.nexus.hr.model.Employee;
import com.nexus.hr.model.LeaveRequest;

public class LeaveRequestMapper {

	// DTO -> ENTITY
	public static LeaveRequest mapToEntity(LeaveRequestDTO dto, Employee emp) {

		LeaveRequest l = new LeaveRequest();

		// l.setId(dto.getId());

		l.setReason(dto.getReason());
		l.setFromDate(dto.getFromDate());
		l.setToDate(dto.getToDate());
		l.setLeaveType(dto.getLeaveType());
		l.setDays(dto.getDays());

		l.setEmployee(emp);

		// default status handled in service
		if (dto.getStatus() != null) {
			l.setStatus(LeaveStatus.valueOf(dto.getStatus().toUpperCase()));
		}

		return l;
	}

	// ENTITY -> DTO
	public static LeaveRequestDTO mapToDTO(LeaveRequest l) {

		LeaveRequestDTO dto = new LeaveRequestDTO();

		dto.setId(l.getId());
		dto.setReason(l.getReason());
		dto.setFromDate(l.getFromDate());
		dto.setToDate(l.getToDate());
		dto.setLeaveType(l.getLeaveType());
		dto.setDays(l.getDays());

		dto.setStatus(l.getStatus() != null ? l.getStatus().name() : null);

		if (l.getEmployee() != null) {
			dto.setEmployeeId(l.getEmployee().getId());
		}

		return dto;
	}
}