package com.nexus.hr.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nexus.hr.dto.AssignmentDTO;
import com.nexus.hr.exception.ResourceNotFoundException;
import com.nexus.hr.mapper.AssignmentMapper;
import com.nexus.hr.model.Assignment;
import com.nexus.hr.model.Employee;
import com.nexus.hr.model.Project;
import com.nexus.hr.repository.AssignmentRepository;
import com.nexus.hr.repository.EmployeeRepository;
import com.nexus.hr.repository.ProjectRepository;
import com.nexus.hr.service.AssignmentService;

@Service
public class AssignmentServiceImpl implements AssignmentService {

	private final AssignmentRepository repo;
	private final EmployeeRepository employeeRepo;
	private final ProjectRepository projectRepo;

	public AssignmentServiceImpl(AssignmentRepository repo, EmployeeRepository employeeRepo,
			ProjectRepository projectRepo) {
		this.repo = repo;
		this.employeeRepo = employeeRepo;
		this.projectRepo = projectRepo;
	}

	@Override
	public AssignmentDTO assignEmployee(AssignmentDTO dto) {

		Employee emp = employeeRepo.findById(dto.getEmployeeId())
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

		Project project = projectRepo.findById(dto.getProjectId())
				.orElseThrow(() -> new ResourceNotFoundException("Project not found"));

		Assignment a = AssignmentMapper.mapToEntity(dto, emp, project);

		return AssignmentMapper.mapToDTO(repo.save(a));
	}

	@Override
	public List<AssignmentDTO> getAll() {
		return repo.findAll().stream().map(AssignmentMapper::mapToDTO).collect(Collectors.toList());
	}

	@Override
	public void remove(Long id) {
		repo.deleteById(id);
	}
}