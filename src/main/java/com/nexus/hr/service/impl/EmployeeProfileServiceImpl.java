package com.nexus.hr.service.impl;

import org.springframework.stereotype.Service;

import com.nexus.hr.dto.EmployeeProfileDTO;
import com.nexus.hr.exception.ResourceNotFoundException;
import com.nexus.hr.mapper.EmployeeProfileMapper;
import com.nexus.hr.model.Employee;
import com.nexus.hr.model.EmployeeProfile;
import com.nexus.hr.repository.EmployeeProfileRepository;
import com.nexus.hr.repository.EmployeeRepository;
import com.nexus.hr.service.EmployeeProfileService;

@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileService {

	private final EmployeeProfileRepository repo;
	private final EmployeeRepository employeeRepo;

	public EmployeeProfileServiceImpl(EmployeeProfileRepository repo, EmployeeRepository employeeRepo) {
		this.repo = repo;
		this.employeeRepo = employeeRepo;
	}

	@Override
	public EmployeeProfileDTO createOrUpdate(EmployeeProfileDTO dto) {

		Employee emp = employeeRepo.findById(dto.getEmployeeId())
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

		EmployeeProfile profile = EmployeeProfileMapper.mapToEntity(dto, emp);

		return EmployeeProfileMapper.mapToDTO(repo.save(profile));
	}

	@Override
	public EmployeeProfileDTO getByEmployeeId(Long employeeId) {

		EmployeeProfile profile = repo.findByEmployeeId(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Profile not found"));

		return EmployeeProfileMapper.mapToDTO(profile);
	}
}