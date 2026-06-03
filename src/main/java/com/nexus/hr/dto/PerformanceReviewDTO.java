package com.nexus.hr.dto;

import java.time.LocalDate;

public class PerformanceReviewDTO {

	private Long id;

	private Integer rating;

	private Double kpiScore;

	private String strengths;

	private String improvements;

	private String managerFeedback;

	private Boolean promotionRecommended;

	private Double bonusAmount;

	private LocalDate reviewDate;

	private String reviewStatus;

	private Long employeeId;

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

	public String getReviewStatus() {
		return reviewStatus;
	}

	public void setReviewStatus(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
}