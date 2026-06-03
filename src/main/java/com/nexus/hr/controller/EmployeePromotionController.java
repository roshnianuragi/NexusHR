package com.nexus.hr.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.nexus.hr.dto.EmployeePromotionDTO;
import com.nexus.hr.service.EmployeePromotionService;

@RestController
@RequestMapping("/api/employees")
public class EmployeePromotionController {

	private final EmployeePromotionService promotionService;

	public EmployeePromotionController(EmployeePromotionService promotionService) {

		this.promotionService = promotionService;
	}

	// PROMOTE EMPLOYEE

	@PutMapping("/{id}/promotion")
	public EmployeePromotionDTO promoteEmployee(

			@PathVariable Long id,

			@RequestBody EmployeePromotionDTO dto) {

		return promotionService.promoteEmployee(id, dto);
	}

	// GET PROMOTION HISTORY

	@GetMapping("/{id}/promotion-history")
	public List<EmployeePromotionDTO> getPromotionHistory(@PathVariable Long id) {

		return promotionService.getPromotionHistory(id);
	}
}