package com.nexus.hr.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.nexus.hr.dto.EmployeeTransferDTO;
import com.nexus.hr.service.EmployeeTransferService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeTransferController {

	private final EmployeeTransferService transferService;

	public EmployeeTransferController(EmployeeTransferService transferService) {
		this.transferService = transferService;
	}

	// TRANSFER EMPLOYEE
	@PutMapping("/{employeeId}/transfer")
	public EmployeeTransferDTO transferEmployee(@PathVariable Long employeeId, @RequestBody EmployeeTransferDTO dto) {

		return transferService.transferEmployee(employeeId, dto);
	}

	// TRANSFER HISTORY
	@GetMapping("/{employeeId}/transfer-history")
	public List<EmployeeTransferDTO> getTransferHistory(@PathVariable Long employeeId) {
		return transferService.getTransferHistory(employeeId);
	}
}