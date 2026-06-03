package com.nexus.hr.service;

import java.util.List;

import com.nexus.hr.dto.PerformanceReviewDTO;

public interface PerformanceReviewService {

	PerformanceReviewDTO createReview(PerformanceReviewDTO dto);

	PerformanceReviewDTO getReviewById(Long id);

	List<PerformanceReviewDTO> getEmployeeReviews(Long employeeId);

	List<PerformanceReviewDTO> getTopPerformers();

	void deleteReview(Long id);
}