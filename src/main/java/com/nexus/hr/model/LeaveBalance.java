package com.nexus.hr.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class LeaveBalance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int totalCL;
	private int usedCL;

	private int totalPL;
	private int usedPL;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
	@com.fasterxml.jackson.annotation.JsonIgnore
	private Employee employee;

	// GETTERS & SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTotalCL() {
		return totalCL;
	}

	public void setTotalCL(int totalCL) {
		this.totalCL = totalCL;
	}

	public int getUsedCL() {
		return usedCL;
	}

	public void setUsedCL(int usedCL) {
		this.usedCL = usedCL;
	}

	public int getTotalPL() {
		return totalPL;
	}

	public void setTotalPL(int totalPL) {
		this.totalPL = totalPL;
	}

	public int getUsedPL() {
		return usedPL;
	}

	public void setUsedPL(int usedPL) {
		this.usedPL = usedPL;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	// SAFE toString

	@Override
	public String toString() {
		return "LeaveBalance{" + "id=" + id + ", totalCL=" + totalCL + ", usedCL=" + usedCL + ", totalPL=" + totalPL
				+ ", usedPL=" + usedPL + '}';
	}
}