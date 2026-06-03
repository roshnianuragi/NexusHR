package com.nexus.hr.dto;

import java.time.LocalDateTime;

public class EmployeeTransferDTO {

	private Long employeeId; 

	private Long oldDepartmentId;
	private Long newDepartmentId;

	private String reason;
	private LocalDateTime transferDate;

	// GETTERS & SETTERS

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getOldDepartmentId() {
		return oldDepartmentId;
	}

	public void setOldDepartmentId(Long oldDepartmentId) {
		this.oldDepartmentId = oldDepartmentId;
	}

	public Long getNewDepartmentId() {
		return newDepartmentId;
	}

	public void setNewDepartmentId(Long newDepartmentId) {
		this.newDepartmentId = newDepartmentId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public LocalDateTime getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(LocalDateTime transferDate) {
		this.transferDate = transferDate;
	}
}