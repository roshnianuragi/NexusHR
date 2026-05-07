package com.nexus.hr.service;

import java.util.List;
import com.nexus.hr.dto.LeaveRequestDTO;

public interface LeaveRequestService {

	LeaveRequestDTO applyLeave(LeaveRequestDTO dto);

	LeaveRequestDTO getLeaveById(Long id);

	List<LeaveRequestDTO> getAllLeaves();

	List<LeaveRequestDTO> getLeavesByEmployee(Long employeeId);

	LeaveRequestDTO updateLeaveStatus(Long id, String status);

	void deleteLeave(Long id);
}