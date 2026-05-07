package com.nexus.hr.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String projectName;
	private String clientName;

	private LocalDate startDate;
	private LocalDate endDate;

	private String status;

	@ManyToMany(mappedBy = "projects", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Employee> employees;

	// GETTERS & SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	// toString SAFE
	@Override
	public String toString() {
		return "Project{" + "id=" + id + ", projectName='" + projectName + '\'' + ", clientName='" + clientName + '\''
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", status='" + status + '\'' + '}';
	}
}