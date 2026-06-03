package com.nexus.hr.dto;

import java.time.LocalDateTime;

public class EmployeePromotionDTO {

	private Long employeeId;

	private String oldDesignation;

	private Double oldSalary;

	private String newDesignation;

	private Double newSalary;

	private String reason;

	private LocalDateTime promotionDate;

	// GETTERS & SETTERS

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getOldDesignation() {
		return oldDesignation;
	}

	public void setOldDesignation(String oldDesignation) {

		this.oldDesignation = oldDesignation;
	}

	public Double getOldSalary() {
		return oldSalary;
	}

	public void setOldSalary(Double oldSalary) {
		this.oldSalary = oldSalary;
	}

	public String getNewDesignation() {
		return newDesignation;
	}

	public void setNewDesignation(String newDesignation) {

		this.newDesignation = newDesignation;
	}

	public Double getNewSalary() {
		return newSalary;
	}

	public void setNewSalary(Double newSalary) {
		this.newSalary = newSalary;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public LocalDateTime getPromotionDate() {
		return promotionDate;
	}

	public void setPromotionDate(LocalDateTime promotionDate) {

		this.promotionDate = promotionDate;
	}
}