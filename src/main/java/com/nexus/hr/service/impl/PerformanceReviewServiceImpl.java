package com.nexus.hr.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nexus.hr.dto.PerformanceReviewDTO;
import com.nexus.hr.enums.ReviewStatus;
import com.nexus.hr.exception.ResourceNotFoundException;
import com.nexus.hr.mapper.PerformanceReviewMapper;
import com.nexus.hr.model.Employee;
import com.nexus.hr.model.PerformanceReview;
import com.nexus.hr.repository.EmployeeRepository;
import com.nexus.hr.repository.PerformanceReviewRepository;
import com.nexus.hr.service.PerformanceReviewService;

@Service
@Transactional
public class PerformanceReviewServiceImpl implements PerformanceReviewService {

	private final PerformanceReviewRepository reviewRepository;

	private final EmployeeRepository employeeRepository;

	public PerformanceReviewServiceImpl(PerformanceReviewRepository reviewRepository,
			EmployeeRepository employeeRepository) {

		this.reviewRepository = reviewRepository;
		this.employeeRepository = employeeRepository;
	}

	// CREATE REVIEW

	@Override
	public PerformanceReviewDTO createReview(PerformanceReviewDTO dto) {

		Employee employee = employeeRepository.findById(dto.getEmployeeId())
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

		PerformanceReview review = PerformanceReviewMapper.mapToEntity(dto, employee);

		review.setReviewDate(LocalDate.now());

		review.setReviewStatus(ReviewStatus.COMPLETED);

		return PerformanceReviewMapper.mapToDTO(reviewRepository.save(review));
	}

	// GET REVIEW

	@Override
	public PerformanceReviewDTO getReviewById(Long id) {

		PerformanceReview review = reviewRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Review not found"));

		return PerformanceReviewMapper.mapToDTO(review);
	}

	// EMPLOYEE REVIEWS

	@Override
	public List<PerformanceReviewDTO> getEmployeeReviews(Long employeeId) {

		return reviewRepository.findByEmployeeId(employeeId).stream().map(PerformanceReviewMapper::mapToDTO)
				.collect(Collectors.toList());
	}

	// TOP PERFORMERS

	@Override
	public List<PerformanceReviewDTO> getTopPerformers() {

		return reviewRepository.findByRatingGreaterThanEqual(4).stream().map(PerformanceReviewMapper::mapToDTO)
				.collect(Collectors.toList());
	}

	// DELETE REVIEW

	@Override
	public void deleteReview(Long id) {

		PerformanceReview review = reviewRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Review not found"));

		reviewRepository.delete(review);
	}
}