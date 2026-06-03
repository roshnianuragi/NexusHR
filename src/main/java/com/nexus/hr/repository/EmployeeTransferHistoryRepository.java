package com.nexus.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexus.hr.model.EmployeeTransferHistory;

public interface EmployeeTransferHistoryRepository extends JpaRepository<EmployeeTransferHistory, Long> {

	List<EmployeeTransferHistory> findByEmployeeId(Long employeeId);
}