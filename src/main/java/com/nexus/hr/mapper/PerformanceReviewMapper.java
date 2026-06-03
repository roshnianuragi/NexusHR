package com.nexus.hr.mapper;

import com.nexus.hr.dto.PerformanceReviewDTO;
import com.nexus.hr.enums.ReviewStatus;
import com.nexus.hr.model.Employee;
import com.nexus.hr.model.PerformanceReview;

public class PerformanceReviewMapper {

	// ENTITY -> DTO

	public static PerformanceReviewDTO mapToDTO(PerformanceReview review) {

		PerformanceReviewDTO dto = new PerformanceReviewDTO();

		dto.setId(review.getId());

		dto.setRating(review.getRating());

		dto.setKpiScore(review.getKpiScore());

		dto.setStrengths(review.getStrengths());

		dto.setImprovements(review.getImprovements());

		dto.setManagerFeedback(review.getManagerFeedback());

		dto.setPromotionRecommended(review.getPromotionRecommended());

		dto.setBonusAmount(review.getBonusAmount());

		dto.setReviewDate(review.getReviewDate());

		dto.setReviewStatus(review.getReviewStatus().name());

		dto.setEmployeeId(review.getEmployee().getId());

		return dto;
	}

	// DTO -> ENTITY

	public static PerformanceReview mapToEntity(PerformanceReviewDTO dto, Employee employee) {

		PerformanceReview review = new PerformanceReview();

		review.setRating(dto.getRating());

		review.setKpiScore(dto.getKpiScore());

		review.setStrengths(dto.getStrengths());

		review.setImprovements(dto.getImprovements());

		review.setManagerFeedback(dto.getManagerFeedback());

		review.setPromotionRecommended(dto.getPromotionRecommended());

		review.setBonusAmount(dto.getBonusAmount());

		review.setReviewDate(dto.getReviewDate());

		review.setReviewStatus(ReviewStatus.valueOf(dto.getReviewStatus()));

		review.setEmployee(employee);

		return review;
	}
}