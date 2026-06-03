package com.nexus.hr.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nexus.hr.dto.ProjectMilestoneDTO;
import com.nexus.hr.enums.MilestoneStatus;
import com.nexus.hr.exception.ResourceNotFoundException;
import com.nexus.hr.mapper.ProjectMilestoneMapper;
import com.nexus.hr.model.Project;
import com.nexus.hr.model.ProjectMilestone;
import com.nexus.hr.repository.ProjectMilestoneRepository;
import com.nexus.hr.repository.ProjectRepository;
import com.nexus.hr.service.ProjectMilestoneService;

@Service
@Transactional
public class ProjectMilestoneServiceImpl implements ProjectMilestoneService {

	private final ProjectMilestoneRepository milestoneRepository;

	private final ProjectRepository projectRepository;

	public ProjectMilestoneServiceImpl(ProjectMilestoneRepository milestoneRepository,
			ProjectRepository projectRepository) {

		this.milestoneRepository = milestoneRepository;

		this.projectRepository = projectRepository;
	}

	// CREATE MILESTONE

	@Override
	public ProjectMilestoneDTO createMilestone(ProjectMilestoneDTO dto) {

		Project project = projectRepository.findById(dto.getProjectId())
				.orElseThrow(() -> new ResourceNotFoundException("Project not found"));

		ProjectMilestone milestone = ProjectMilestoneMapper.mapToEntity(dto, project);

		return ProjectMilestoneMapper.mapToDTO(milestoneRepository.save(milestone));
	}

	// PROJECT BACKLOG

	@Override
	public List<ProjectMilestoneDTO> getProjectBacklog(Long projectId) {

		return milestoneRepository.findByProjectId(projectId).stream().map(ProjectMilestoneMapper::mapToDTO)
				.collect(Collectors.toList());
	}

	// UPDATE STATUS

	@Override
	public ProjectMilestoneDTO updateMilestoneStatus(Long milestoneId, String status) {

		ProjectMilestone milestone = milestoneRepository.findById(milestoneId)
				.orElseThrow(() -> new ResourceNotFoundException("Milestone not found"));

		milestone.setStatus(MilestoneStatus.valueOf(status.toUpperCase()));

		return ProjectMilestoneMapper.mapToDTO(milestoneRepository.save(milestone));
	}

	// DELETE

	@Override
	public void deleteMilestone(Long milestoneId) {

		ProjectMilestone milestone = milestoneRepository.findById(milestoneId)
				.orElseThrow(() -> new ResourceNotFoundException("Milestone not found"));

		milestoneRepository.delete(milestone);
	}
}