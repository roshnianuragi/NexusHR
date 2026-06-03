package com.nexus.hr.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nexus.hr.dto.ProjectDTO;
import com.nexus.hr.exception.ResourceNotFoundException;
import com.nexus.hr.mapper.ProjectMapper;
import com.nexus.hr.model.Employee;
import com.nexus.hr.model.Project;
import com.nexus.hr.repository.EmployeeRepository;
import com.nexus.hr.repository.ProjectRepository;
import com.nexus.hr.service.ProjectService;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

	private final ProjectRepository repo;
	private final EmployeeRepository employeeRepository;

	public ProjectServiceImpl(ProjectRepository repo, EmployeeRepository employeeRepository) {

		this.repo = repo;
		this.employeeRepository = employeeRepository;
	}

	// CREATE PROJECT
	@Override
	public ProjectDTO create(ProjectDTO dto) {

		Project project = ProjectMapper.mapToEntity(dto);

		return ProjectMapper.mapToDTO(repo.save(project));
	}

	// GET PROJECT BY ID
	@Override
	public ProjectDTO getById(Long id) {

		Project project = repo.findById(id)

				.orElseThrow(() -> new ResourceNotFoundException("Project not found"));

		return ProjectMapper.mapToDTO(project);
	}

	// GET ALL PROJECTS
	@Override
	public List<ProjectDTO> getAll() {

		return repo.findAll()

				.stream()

				.map(ProjectMapper::mapToDTO)

				.collect(Collectors.toList());
	}

	// UPDATE PROJECT
	@Override
	public ProjectDTO update(Long id, ProjectDTO dto) {

		Project project = repo.findById(id)

				.orElseThrow(() -> new ResourceNotFoundException("Project not found"));

		project.setProjectName(dto.getProjectName());

		project.setClientName(dto.getClientName());

		project.setStartDate(dto.getStartDate());

		project.setEndDate(dto.getEndDate());

		project.setStatus(dto.getStatus());

		return ProjectMapper.mapToDTO(repo.save(project));
	}

	// DELETE PROJECT
	@Override
	public void delete(Long id) {

		Project project = repo.findById(id)

				.orElseThrow(() -> new ResourceNotFoundException("Project not found"));

		repo.delete(project);
	}

	// ASSIGN EMPLOYEES TO PROJECT
	@Override
	public void assignEmployees(Long projectId, List<Long> employeeIds) {

		Project project = repo.findById(projectId)

				.orElseThrow(() -> new ResourceNotFoundException("Project not found"));

		List<Employee> employees = employeeRepository.findAllById(employeeIds);

		for (Employee employee : employees) {

			List<Project> projects = employee.getProjects();

			// NULL SAFETY
			if (projects != null && !projects.contains(project)) {

				projects.add(project);

				employee.setProjects(projects);

				employeeRepository.save(employee);
			}
		}
	}

	// REMOVE EMPLOYEE FROM PROJECT
	@Override
	public void removeEmployee(Long projectId, Long employeeId) {

		Project project = repo.findById(projectId)

				.orElseThrow(() -> new ResourceNotFoundException("Project not found"));

		Employee employee = employeeRepository.findById(employeeId)

				.orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

		List<Project> projects = employee.getProjects();

		projects.removeIf(p -> p.getId().equals(projectId));

		employee.setProjects(projects);

		employeeRepository.save(employee);
	}
}