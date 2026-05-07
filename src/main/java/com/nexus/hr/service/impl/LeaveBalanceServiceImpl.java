package com.nexus.hr.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nexus.hr.dto.LeaveBalanceDTO;
import com.nexus.hr.exception.ResourceNotFoundException;
import com.nexus.hr.model.Employee;
import com.nexus.hr.model.LeaveBalance;
import com.nexus.hr.repository.EmployeeRepository;
import com.nexus.hr.repository.LeaveBalanceRepository;
import com.nexus.hr.service.LeaveBalanceService;

@Service
@Transactional
public class LeaveBalanceServiceImpl implements LeaveBalanceService {

	private final LeaveBalanceRepository balanceRepo;
	private final EmployeeRepository employeeRepo;

	public LeaveBalanceServiceImpl(LeaveBalanceRepository balanceRepo, EmployeeRepository employeeRepo) {
		this.balanceRepo = balanceRepo;
		this.employeeRepo = employeeRepo;
	}

	// GET BY EMPLOYEE ID
	@Override
	public LeaveBalanceDTO getByEmployeeId(Long employeeId) {

		Employee emp = employeeRepo.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

		LeaveBalance lb = balanceRepo.findByEmployee(emp)
				.orElseThrow(() -> new ResourceNotFoundException("Leave balance not found"));

		return mapToDTO(lb);
	}

	// CREATE OR UPDATE BALANCE
	@Override
	public LeaveBalanceDTO createOrUpdateBalance(LeaveBalanceDTO dto) {

		Employee emp = employeeRepo.findById(dto.getEmployeeId())
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

		LeaveBalance lb = balanceRepo.findByEmployee(emp).orElse(new LeaveBalance());

		lb.setEmployee(emp);
		lb.setTotalCL(dto.getTotalCL());
		lb.setUsedCL(dto.getUsedCL());
		lb.setTotalPL(dto.getTotalPL());
		lb.setUsedPL(dto.getUsedPL());

		return mapToDTO(balanceRepo.save(lb));
	}

	// UPDATE AFTER LEAVE APPROVAL (CORE LOGIC)
	@Override
	public void updateAfterLeaveApproval(Long employeeId, String leaveType, int days) {

		Employee emp = employeeRepo.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

		LeaveBalance lb = balanceRepo.findByEmployee(emp)
				.orElseThrow(() -> new ResourceNotFoundException("Leave balance not found"));

		String type = leaveType.trim().toUpperCase();

		switch (type) {

		case "CL":
			lb.setUsedCL(lb.getUsedCL() + days);
			break;

		case "PL":
			lb.setUsedPL(lb.getUsedPL() + days);
			break;

		default:
			throw new IllegalArgumentException("Invalid leave type: " + leaveType);
		}

		balanceRepo.save(lb);
	}

	// MAPPER (internal use)
	private LeaveBalanceDTO mapToDTO(LeaveBalance lb) {

		LeaveBalanceDTO dto = new LeaveBalanceDTO();

		dto.setId(lb.getId());
		dto.setTotalCL(lb.getTotalCL());
		dto.setUsedCL(lb.getUsedCL());
		dto.setTotalPL(lb.getTotalPL());
		dto.setUsedPL(lb.getUsedPL());

		if (lb.getEmployee() != null)
			dto.setEmployeeId(lb.getEmployee().getId());

		return dto;
	}
}