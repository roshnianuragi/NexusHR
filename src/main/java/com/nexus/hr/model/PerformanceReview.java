package com.nexus.hr.model;

import java.time.LocalDate;

import com.nexus.hr.enums.ReviewStatus;

import jakarta.persistence.*;

@Entity
public class PerformanceReview {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer rating;

	private Double kpiScore;

	private String strengths;

	private String improvements;

	private String managerFeedback;

	private Boolean promotionRecommended = false;

	private Double bonusAmount;

	private LocalDate reviewDate;

	@Enumerated(EnumType.STRING)
	private ReviewStatus reviewStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
	@com.fasterxml.jackson.annotation.JsonIgnore
	private Employee employee;

	// GETTERS & SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Double getKpiScore() {
		return kpiScore;
	}

	public void setKpiScore(Double kpiScore) {
		this.kpiScore = kpiScore;
	}

	public String getStrengths() {
		return strengths;
	}

	public void setStrengths(String strengths) {
		this.strengths = strengths;
	}

	public String getImprovements() {
		return improvements;
	}

	public void setImprovements(String improvements) {
		this.improvements = improvements;
	}

	public String getManagerFeedback() {
		return managerFeedback;
	}

	public void setManagerFeedback(String managerFeedback) {
		this.managerFeedback = managerFeedback;
	}

	public Boolean getPromotionRecommended() {
		return promotionRecommended;
	}

	public void setPromotionRecommended(Boolean promotionRecommended) {
		this.promotionRecommended = promotionRecommended;
	}

	public Double getBonusAmount() {
		return bonusAmount;
	}

	public void setBonusAmount(Double bonusAmount) {
		this.bonusAmount = bonusAmount;
	}

	public LocalDate getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(LocalDate reviewDate) {
		this.reviewDate = reviewDate;
	}

	public ReviewStatus getReviewStatus() {
		return reviewStatus;
	}

	public void setReviewStatus(ReviewStatus reviewStatus) {
		this.reviewStatus = reviewStatus;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}