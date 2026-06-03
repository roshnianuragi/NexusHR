package com.nexus.hr.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class DepartmentDTO {

	private Long id;

	@NotBlank(message = "Department name is required")
	private String name;

	@NotBlank(message = "Location is required")
	private String location;

	@Min(value = 1, message = "Budget must be greater than 0")
	private double budget;

	private String description;

	@NotBlank(message = "Head of department is required")
	private String headOfDepartment;

	private boolean active = true;

	// AUDIT FIELDS

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	// GETTERS & SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// NAME

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// LOCATION

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	// BUDGET

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	// DESCRIPTION

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// HEAD OF DEPARTMENT

	public String getHeadOfDepartment() {
		return headOfDepartment;
	}

	public void setHeadOfDepartment(String headOfDepartment) {

		this.headOfDepartment = headOfDepartment;
	}

	// ACTIVE

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	// CREATED AT

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {

		this.createdAt = createdAt;
	}

	// UPDATED AT

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {

		this.updatedAt = updatedAt;
	}
}