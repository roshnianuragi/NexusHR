package com.nexus.hr.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.nexus.hr.dto.LeaveRequestDTO;
import com.nexus.hr.service.LeaveRequestService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/leaves")
public class LeaveRequestController {

	private final LeaveRequestService leaveRequestService;

	public LeaveRequestController(LeaveRequestService leaveRequestService) {
		this.leaveRequestService = leaveRequestService;
	}

	// APPLY LEAVE
	@PostMapping
	public LeaveRequestDTO applyLeave(@Valid @RequestBody LeaveRequestDTO dto) {
		return leaveRequestService.applyLeave(dto);
	}

	// GET BY ID
	@GetMapping("/{id}")
	public LeaveRequestDTO getLeaveById(@PathVariable Long id) {
		return leaveRequestService.getLeaveById(id);
	}

	// GET ALL LEAVES
	@GetMapping
	public List<LeaveRequestDTO> getAllLeaves() {
		return leaveRequestService.getAllLeaves();
	}

	// GET LEAVES BY EMPLOYEE
	@GetMapping("/employee/{employeeId}")
	public List<LeaveRequestDTO> getLeavesByEmployee(@PathVariable Long employeeId) {
		return leaveRequestService.getLeavesByEmployee(employeeId);
	}

	// UPDATE LEAVE STATUS (APPROVE / REJECT)
	@PutMapping("/{id}/status")
	public LeaveRequestDTO updateLeaveStatus(@PathVariable Long id, @RequestParam String status) {
		return leaveRequestService.updateLeaveStatus(id, status);
	}
}