package com.nexus.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexus.hr.model.PerformanceReview;

public interface PerformanceReviewRepository extends JpaRepository<PerformanceReview, Long> {

	List<PerformanceReview> findByEmployeeId(Long employeeId);

	List<PerformanceReview> findByRatingGreaterThanEqual(Integer rating);
}