package com.nexus.hr.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.nexus.hr.dto.PerformanceReviewDTO;
import com.nexus.hr.service.PerformanceReviewService;

@RestController
@RequestMapping("/api/performance")
public class PerformanceReviewController {

	private final PerformanceReviewService performanceReviewService;

	public PerformanceReviewController(PerformanceReviewService performanceReviewService) {

		this.performanceReviewService = performanceReviewService;
	}

	// =========================
	// CREATE REVIEW
	// =========================

	@PostMapping
	public PerformanceReviewDTO createReview(@RequestBody PerformanceReviewDTO dto) {

		return performanceReviewService.createReview(dto);
	}

	// =========================
	// GET REVIEW BY ID
	// =========================

	@GetMapping("/{id}")
	public PerformanceReviewDTO getReview(@PathVariable Long id) {

		return performanceReviewService.getReviewById(id);
	}

	// =========================
	// EMPLOYEE REVIEWS
	// =========================

	@GetMapping("/employee/{employeeId}")
	public List<PerformanceReviewDTO> getEmployeeReviews(@PathVariable Long employeeId) {

		return performanceReviewService.getEmployeeReviews(employeeId);
	}

	// =========================
	// TOP PERFORMERS
	// =========================

	@GetMapping("/top-performers")
	public List<PerformanceReviewDTO> getTopPerformers() {

		return performanceReviewService.getTopPerformers();
	}

	// =========================
	// DELETE REVIEW
	// =========================

	@DeleteMapping("/{id}")
	public String deleteReview(@PathVariable Long id) {

		performanceReviewService.deleteReview(id);

		return "Review deleted successfully";
	}
}