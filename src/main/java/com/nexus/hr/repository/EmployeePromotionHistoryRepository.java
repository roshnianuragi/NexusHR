package com.nexus.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexus.hr.model.EmployeePromotionHistory;

public interface EmployeePromotionHistoryRepository extends JpaRepository<EmployeePromotionHistory, Long> {

	List<EmployeePromotionHistory> findByEmployeeId(Long employeeId);
}