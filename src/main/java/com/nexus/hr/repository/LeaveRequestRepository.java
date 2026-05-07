package com.nexus.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexus.hr.enums.LeaveStatus;
import com.nexus.hr.model.LeaveRequest;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {

	List<LeaveRequest> findByEmployeeId(Long employeeId);

	List<LeaveRequest> findByStatus(LeaveStatus status);
}