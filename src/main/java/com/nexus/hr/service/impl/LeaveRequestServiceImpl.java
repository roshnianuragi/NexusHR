package com.nexus.hr.service.impl;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nexus.hr.dto.LeaveRequestDTO;
import com.nexus.hr.enums.LeaveStatus;
import com.nexus.hr.exception.ResourceNotFoundException;
import com.nexus.hr.mapper.LeaveRequestMapper;
import com.nexus.hr.model.Employee;
import com.nexus.hr.model.LeaveRequest;
import com.nexus.hr.repository.EmployeeRepository;
import com.nexus.hr.repository.LeaveRequestRepository;
import com.nexus.hr.service.LeaveBalanceService;
import com.nexus.hr.service.LeaveRequestService;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {

	private final LeaveRequestRepository leaveRepo;
	private final EmployeeRepository empRepo;
	private final LeaveBalanceService balanceService;

	public LeaveRequestServiceImpl(LeaveRequestRepository leaveRepo, EmployeeRepository empRepo,
			LeaveBalanceService balanceService) {
		this.leaveRepo = leaveRepo;
		this.empRepo = empRepo;
		this.balanceService = balanceService;
	}

	@Override
	public LeaveRequestDTO applyLeave(LeaveRequestDTO dto) {

		Employee emp = empRepo.findById(dto.getEmployeeId())
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

		LeaveRequest leave = LeaveRequestMapper.mapToEntity(dto, emp);

		leave.setStatus(LeaveStatus.PENDING);

		return LeaveRequestMapper.mapToDTO(leaveRepo.save(leave));
	}

	@Override
	public LeaveRequestDTO getLeaveById(Long id) {

		LeaveRequest leave = leaveRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Leave not found"));

		return LeaveRequestMapper.mapToDTO(leave);
	}

	@Override
	public List<LeaveRequestDTO> getAllLeaves() {

		return leaveRepo.findAll().stream().map(LeaveRequestMapper::mapToDTO).collect(Collectors.toList());
	}

	@Override
	public List<LeaveRequestDTO> getLeavesByEmployee(Long employeeId) {

		return leaveRepo.findByEmployeeId(employeeId).stream().map(LeaveRequestMapper::mapToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public LeaveRequestDTO updateLeaveStatus(Long id, String status) {

		LeaveRequest leave = leaveRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Leave not found"));

		LeaveStatus newStatus = LeaveStatus.valueOf(status.trim().toUpperCase());

		leave.setStatus(newStatus);

		// AUTO BALANCE UPDATE
		if (newStatus == LeaveStatus.APPROVED) {

			int days = (int) ChronoUnit.DAYS.between(leave.getFromDate(), leave.getToDate());

			leave.setDays(days);

			balanceService.updateAfterLeaveApproval(leave.getEmployee().getId(), leave.getLeaveType(), days);
		}

		return LeaveRequestMapper.mapToDTO(leaveRepo.save(leave));
	}

	@Override
	public void deleteLeave(Long id) {

		LeaveRequest leave = leaveRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Leave not found"));

		leaveRepo.delete(leave);
	}
}