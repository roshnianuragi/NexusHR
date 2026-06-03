package com.nexus.hr.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.nexus.hr.dto.AttendanceDTO;
import com.nexus.hr.service.AttendanceService;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

	private final AttendanceService attendanceService;

	public AttendanceController(AttendanceService attendanceService) {

		this.attendanceService = attendanceService;
	}

	// CHECK IN

	@PostMapping("/check-in/{employeeId}")
	public AttendanceDTO checkIn(@PathVariable Long employeeId) {

		return attendanceService.checkIn(employeeId);
	}

	// CHECK OUT

	@PostMapping("/check-out/{employeeId}")
	public AttendanceDTO checkOut(@PathVariable Long employeeId) {

		return attendanceService.checkOut(employeeId);
	}

	// GET ATTENDANCE

	@GetMapping("/employee/{employeeId}")
	public List<AttendanceDTO> getAttendance(@PathVariable Long employeeId) {

		return attendanceService.getEmployeeAttendance(employeeId);
	}
}