package com.nexus.hr.dto;

public class LeaveBalanceDTO {

	private Long id;
	private int totalCL;
	private int usedCL;
	private int totalPL;
	private int usedPL;
	private Long employeeId;

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

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
}