package com.nexus.hr.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class EmployeePromotionHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// EMPLOYEE

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
	@com.fasterxml.jackson.annotation.JsonIgnore
	private Employee employee;

	// OLD DETAILS

	private String oldDesignation;

	private Double oldSalary;

	// NEW DETAILS

	private String newDesignation;

	private Double newSalary;

	// PROMOTION INFO

	private String reason;

	private LocalDateTime promotionDate;

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