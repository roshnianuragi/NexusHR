package com.nexus.hr.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nexus.hr.dto.AttendanceDTO;
import com.nexus.hr.enums.AttendanceStatus;
import com.nexus.hr.exception.ResourceNotFoundException;
import com.nexus.hr.mapper.AttendanceMapper;
import com.nexus.hr.model.Attendance;
import com.nexus.hr.model.Employee;
import com.nexus.hr.repository.AttendanceRepository;
import com.nexus.hr.repository.EmployeeRepository;
import com.nexus.hr.service.AttendanceService;

@Service
@Transactional
public class AttendanceServiceImpl implements AttendanceService {

	private final AttendanceRepository attendanceRepository;

	private final EmployeeRepository employeeRepository;

	public AttendanceServiceImpl(AttendanceRepository attendanceRepository, EmployeeRepository employeeRepository) {

		this.attendanceRepository = attendanceRepository;
		this.employeeRepository = employeeRepository;
	}

	// CHECK IN

	@Override
	public AttendanceDTO checkIn(Long employeeId) {

		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

		LocalDate today = LocalDate.now();

		if (attendanceRepository.findByEmployeeIdAndAttendanceDate(employeeId, today).isPresent()) {

			throw new RuntimeException("Already checked in today");
		}

		Attendance attendance = new Attendance();

		attendance.setAttendanceDate(today);

		attendance.setCheckInTime(LocalDateTime.now());

		attendance.setStatus(AttendanceStatus.PRESENT);

		attendance.setEmployee(employee);

		// LATE MARK

		LocalTime officeTime = LocalTime.of(9, 30);

		if (LocalTime.now().isAfter(officeTime)) {

			attendance.setLateMark(true);
		}

		return AttendanceMapper.mapToDTO(attendanceRepository.save(attendance));
	}

	// CHECK OUT

	@Override
	public AttendanceDTO checkOut(Long employeeId) {

		Attendance attendance = attendanceRepository.findByEmployeeIdAndAttendanceDate(employeeId, LocalDate.now())
				.orElseThrow(() -> new RuntimeException("Check-in not found"));

		attendance.setCheckOutTime(LocalDateTime.now());

		attendance.calculateHours();

		return AttendanceMapper.mapToDTO(attendanceRepository.save(attendance));
	}

	// GET ATTENDANCE

	@Override
	public List<AttendanceDTO> getEmployeeAttendance(Long employeeId) {

		return attendanceRepository.findByEmployeeId(employeeId).stream().map(AttendanceMapper::mapToDTO)
				.collect(Collectors.toList());
	}
}