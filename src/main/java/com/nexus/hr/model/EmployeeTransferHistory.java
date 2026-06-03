package com.nexus.hr.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class EmployeeTransferHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// EMPLOYEE

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
	@com.fasterxml.jackson.annotation.JsonIgnore
	private Employee employee;

	// OLD DEPARTMENT

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "old_department_id")
	private Department oldDepartment;

	// NEW DEPARTMENT

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "new_department_id")
	private Department newDepartment;

	// TRANSFER DETAILS

	private String reason;

	private LocalDateTime transferDate;

	// GETTERS & SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Department getOldDepartment() {
		return oldDepartment;
	}

	public void setOldDepartment(Department oldDepartment) {

		this.oldDepartment = oldDepartment;
	}

	public Department getNewDepartment() {
		return newDepartment;
	}

	public void setNewDepartment(Department newDepartment) {

		this.newDepartment = newDepartment;
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