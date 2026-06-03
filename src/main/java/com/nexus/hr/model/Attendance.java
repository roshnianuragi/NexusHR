package com.nexus.hr.model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.nexus.hr.enums.AttendanceStatus;

import jakarta.persistence.*;

@Entity
public class Attendance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate attendanceDate;

	private LocalDateTime checkInTime;

	private LocalDateTime checkOutTime;

	private Double totalHours;

	private Boolean lateMark = false;

	@Enumerated(EnumType.STRING)
	private AttendanceStatus status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
	@com.fasterxml.jackson.annotation.JsonIgnore
	private Employee employee;

	// AUTO CALCULATE HOURS

	public void calculateHours() {

		if (checkInTime != null && checkOutTime != null) {

			long minutes = Duration.between(checkInTime, checkOutTime).toMinutes();

			this.totalHours = minutes / 60.0;
		}
	}

	// GETTERS & SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getAttendanceDate() {
		return attendanceDate;
	}

	public void setAttendanceDate(LocalDate attendanceDate) {
		this.attendanceDate = attendanceDate;
	}

	public LocalDateTime getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(LocalDateTime checkInTime) {
		this.checkInTime = checkInTime;
	}

	public LocalDateTime getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(LocalDateTime checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	public Double getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(Double totalHours) {
		this.totalHours = totalHours;
	}

	public Boolean getLateMark() {
		return lateMark;
	}

	public void setLateMark(Boolean lateMark) {
		this.lateMark = lateMark;
	}

	public AttendanceStatus getStatus() {
		return status;
	}

	public void setStatus(AttendanceStatus status) {
		this.status = status;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}