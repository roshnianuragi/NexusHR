package com.nexus.hr.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nexus.hr.dto.EmployeePromotionDTO;
import com.nexus.hr.exception.ResourceNotFoundException;
import com.nexus.hr.model.Employee;
import com.nexus.hr.model.EmployeePromotionHistory;
import com.nexus.hr.repository.EmployeePromotionHistoryRepository;
import com.nexus.hr.repository.EmployeeRepository;
import com.nexus.hr.service.EmployeePromotionService;

@Service
@Transactional
public class EmployeePromotionServiceImpl implements EmployeePromotionService {

	private final EmployeeRepository employeeRepository;

	private final EmployeePromotionHistoryRepository promotionRepository;

	public EmployeePromotionServiceImpl(

			EmployeeRepository employeeRepository,

			EmployeePromotionHistoryRepository promotionRepository) {

		this.employeeRepository = employeeRepository;

		this.promotionRepository = promotionRepository;
	}

	// PROMOTE EMPLOYEE

	@Override
	public EmployeePromotionDTO promoteEmployee(

			Long employeeId, EmployeePromotionDTO dto) {

		// FIND EMPLOYEE

		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

		// OLD VALUES

		String oldDesignation = employee.getDesignation();

		Double oldSalary = employee.getSalary();

		// UPDATE EMPLOYEE

		employee.setDesignation(dto.getNewDesignation());

		employee.setSalary(dto.getNewSalary());

		employeeRepository.save(employee);

		// SAVE HISTORY

		EmployeePromotionHistory history = new EmployeePromotionHistory();

		history.setEmployee(employee);

		history.setOldDesignation(oldDesignation);

		history.setOldSalary(oldSalary);

		history.setNewDesignation(dto.getNewDesignation());

		history.setNewSalary(dto.getNewSalary());

		history.setReason(dto.getReason());

		history.setPromotionDate(LocalDateTime.now());

		promotionRepository.save(history);

		// RESPONSE DTO

		EmployeePromotionDTO response = new EmployeePromotionDTO();

		response.setEmployeeId(employee.getId());

		response.setOldDesignation(oldDesignation);

		response.setOldSalary(oldSalary);

		response.setNewDesignation(dto.getNewDesignation());

		response.setNewSalary(dto.getNewSalary());

		response.setReason(dto.getReason());

		response.setPromotionDate(history.getPromotionDate());

		return response;
	}

	// GET HISTORY

	@Override
	public List<EmployeePromotionDTO> getPromotionHistory(Long employeeId) {

		return promotionRepository.findByEmployeeId(employeeId).stream().map(history -> {

			EmployeePromotionDTO dto = new EmployeePromotionDTO();

			dto.setEmployeeId(history.getEmployee().getId());

			dto.setOldDesignation(history.getOldDesignation());

			dto.setOldSalary(history.getOldSalary());

			dto.setNewDesignation(history.getNewDesignation());

			dto.setNewSalary(history.getNewSalary());

			dto.setReason(history.getReason());

			dto.setPromotionDate(history.getPromotionDate());

			return dto;
		}).collect(Collectors.toList());
	}
}