package com.nexus.hr.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nexus.hr.dto.ProjectDTO;
import com.nexus.hr.exception.ResourceNotFoundException;
import com.nexus.hr.mapper.ProjectMapper;
import com.nexus.hr.model.Project;
import com.nexus.hr.repository.ProjectRepository;
import com.nexus.hr.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	private final ProjectRepository repo;

	public ProjectServiceImpl(ProjectRepository repo) {
		this.repo = repo;
	}

	@Override
	public ProjectDTO create(ProjectDTO dto) {
		Project p = ProjectMapper.mapToEntity(dto);
		return ProjectMapper.mapToDTO(repo.save(p));
	}

	@Override
	public ProjectDTO getById(Long id) {
		Project p = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project not found"));
		return ProjectMapper.mapToDTO(p);
	}

	@Override
	public List<ProjectDTO> getAll() {
		return repo.findAll().stream().map(ProjectMapper::mapToDTO).collect(Collectors.toList());
	}

	@Override
	public ProjectDTO update(Long id, ProjectDTO dto) {

		Project p = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project not found"));

		p.setProjectName(dto.getProjectName());
		p.setClientName(dto.getClientName());
		p.setStatus(dto.getStatus());

		return ProjectMapper.mapToDTO(repo.save(p));
	}

	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
}