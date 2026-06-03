package com.nexus.hr.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexus.hr.model.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

	Optional<Attendance> findByEmployeeIdAndAttendanceDate(Long employeeId, LocalDate attendanceDate);

	List<Attendance> findByEmployeeId(Long employeeId);

	List<Attendance> findByAttendanceDate(LocalDate date);
}