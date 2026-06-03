package com.nexus.hr.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String location;

	private double budget;

	private String description;

	private String headOfDepartment;

	private boolean active = true;

	// AUDIT FIELDS

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@com.fasterxml.jackson.annotation.JsonIgnore
	private List<Employee> employees;

	// AUTO TIMESTAMP

	@PrePersist
	public void onCreate() {

		this.createdAt = LocalDateTime.now();

		this.updatedAt = LocalDateTime.now();
	}

	@PreUpdate
	public void onUpdate() {

		this.updatedAt = LocalDateTime.now();
	}

	// GETTERS & SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHeadOfDepartment() {
		return headOfDepartment;
	}

	public void setHeadOfDepartment(String headOfDepartment) {
		this.headOfDepartment = headOfDepartment;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
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

	// TOSTRING

	@Override
	public String toString() {

		return "Department{"

				+ "id=" + id

				+ ", name='" + name + '\''

				+ ", location='" + location + '\''

				+ ", budget=" + budget

				+ ", description='" + description + '\''

				+ ", headOfDepartment='" + headOfDepartment + '\''

				+ ", active=" + active

				+ ", createdAt=" + createdAt

				+ ", updatedAt=" + updatedAt

				+ '}';
	}
}