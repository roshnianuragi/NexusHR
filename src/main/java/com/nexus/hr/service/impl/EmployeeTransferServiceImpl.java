package com.nexus.hr.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nexus.hr.dto.EmployeeTransferDTO;
import com.nexus.hr.exception.ResourceNotFoundException;
import com.nexus.hr.model.Department;
import com.nexus.hr.model.Employee;
import com.nexus.hr.model.EmployeeTransferHistory;
import com.nexus.hr.repository.DepartmentRepository;
import com.nexus.hr.repository.EmployeeRepository;
import com.nexus.hr.repository.EmployeeTransferHistoryRepository;
import com.nexus.hr.service.EmployeeTransferService;

@Service
@Transactional
public class EmployeeTransferServiceImpl implements EmployeeTransferService {

	private final EmployeeRepository employeeRepository;
	private final DepartmentRepository departmentRepository;
	private final EmployeeTransferHistoryRepository transferRepository;

	public EmployeeTransferServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository,
			EmployeeTransferHistoryRepository transferRepository) {
		this.employeeRepository = employeeRepository;
		this.departmentRepository = departmentRepository;
		this.transferRepository = transferRepository;
	}

	@Override
	public EmployeeTransferDTO transferEmployee(Long employeeId, EmployeeTransferDTO dto) {

		// VALIDATION
		if (dto.getNewDepartmentId() == null) {
			throw new ResourceNotFoundException("newDepartmentId cannot be null");
		}

		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

		Department oldDepartment = employee.getDepartment();

		Department newDepartment = departmentRepository.findById(dto.getNewDepartmentId())
				.orElseThrow(() -> new ResourceNotFoundException("Department not found"));

		// TRANSFER
		employee.setDepartment(newDepartment);
		employeeRepository.save(employee);

		// HISTORY SAVE
		EmployeeTransferHistory history = new EmployeeTransferHistory();
		history.setEmployee(employee);
		history.setOldDepartment(oldDepartment);
		history.setNewDepartment(newDepartment);
		history.setReason(dto.getReason());
		history.setTransferDate(LocalDateTime.now());

		transferRepository.save(history);

		// RESPONSE (FIXED IMPORTANT)
		EmployeeTransferDTO response = new EmployeeTransferDTO();

		response.setEmployeeId(employee.getId());

		response.setOldDepartmentId(oldDepartment.getId());
		response.setNewDepartmentId(newDepartment.getId());
		response.setReason(dto.getReason());
		response.setTransferDate(history.getTransferDate());

		return response;
	}

	@Override
	public List<EmployeeTransferDTO> getTransferHistory(Long employeeId) {

		return transferRepository.findByEmployeeId(employeeId).stream().map(history -> {

			EmployeeTransferDTO dto = new EmployeeTransferDTO();

			dto.setEmployeeId(history.getEmployee().getId());

			dto.setOldDepartmentId(history.getOldDepartment().getId());
			dto.setNewDepartmentId(history.getNewDepartment().getId());
			dto.setReason(history.getReason());
			dto.setTransferDate(history.getTransferDate());

			return dto;
		}).collect(Collectors.toList());
	}
}