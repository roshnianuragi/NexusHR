package com.nexus.hr.controller;

import org.springframework.web.bind.annotation.*;

import com.nexus.hr.dto.LeaveBalanceDTO;
import com.nexus.hr.service.LeaveBalanceService;

@RestController
@RequestMapping("/api/leave-balance")
public class LeaveBalanceController {

	private final LeaveBalanceService service;

	public LeaveBalanceController(LeaveBalanceService service) {
		this.service = service;
	}

	// GET BALANCE
	@GetMapping("/employee/{employeeId}")
	public LeaveBalanceDTO getByEmployeeId(@PathVariable Long employeeId) {
		return service.getByEmployeeId(employeeId);
	}

	// CREATE / UPDATE BALANCE
	@PostMapping
	public LeaveBalanceDTO createOrUpdate(@RequestBody LeaveBalanceDTO dto) {
		return service.createOrUpdateBalance(dto);
	}

	// UPDATE AFTER LEAVE APPROVAL
	@PostMapping("/update")
	public String updateAfterApproval(@RequestParam Long employeeId, @RequestParam String type,
			@RequestParam int days) {

		service.updateAfterLeaveApproval(employeeId, type, days);
		return "Leave balance updated successfully";
	}
}