package com.nexus.hr.service;

import java.util.List;

import com.nexus.hr.dto.AttendanceDTO;

public interface AttendanceService {

	AttendanceDTO checkIn(Long employeeId);

	AttendanceDTO checkOut(Long employeeId);

	List<AttendanceDTO> getEmployeeAttendance(Long employeeId);
}