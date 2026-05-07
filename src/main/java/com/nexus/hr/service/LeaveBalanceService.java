package com.nexus.hr.service;

import com.nexus.hr.dto.LeaveBalanceDTO;

public interface LeaveBalanceService {

	LeaveBalanceDTO getByEmployeeId(Long employeeId);

	LeaveBalanceDTO createOrUpdateBalance(LeaveBalanceDTO dto);

	void updateAfterLeaveApproval(Long employeeId, String leaveType, int days);
}