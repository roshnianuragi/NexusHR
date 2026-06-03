package com.nexus.hr.mapper;

import com.nexus.hr.dto.AttendanceDTO;
import com.nexus.hr.enums.AttendanceStatus;
import com.nexus.hr.model.Attendance;
import com.nexus.hr.model.Employee;

public class AttendanceMapper {

	// ENTITY -> DTO

	public static AttendanceDTO mapToDTO(Attendance attendance) {

		AttendanceDTO dto = new AttendanceDTO();

		dto.setId(attendance.getId());

		dto.setAttendanceDate(attendance.getAttendanceDate());

		dto.setCheckInTime(attendance.getCheckInTime());

		dto.setCheckOutTime(attendance.getCheckOutTime());

		dto.setTotalHours(attendance.getTotalHours());

		dto.setLateMark(attendance.getLateMark());

		dto.setStatus(attendance.getStatus().name());

		dto.setEmployeeId(attendance.getEmployee().getId());

		return dto;
	}

	// DTO -> ENTITY

	public static Attendance mapToEntity(AttendanceDTO dto, Employee employee) {

		Attendance attendance = new Attendance();

		attendance.setAttendanceDate(dto.getAttendanceDate());

		attendance.setCheckInTime(dto.getCheckInTime());

		attendance.setCheckOutTime(dto.getCheckOutTime());

		attendance.setTotalHours(dto.getTotalHours());

		attendance.setLateMark(dto.getLateMark());

		attendance.setStatus(AttendanceStatus.valueOf(dto.getStatus()));

		attendance.setEmployee(employee);

		return attendance;
	}
}