package com.nexus.hr.service;

import java.util.List;

import com.nexus.hr.dto.ProjectMilestoneDTO;

public interface ProjectMilestoneService {

	ProjectMilestoneDTO createMilestone(ProjectMilestoneDTO dto);

	List<ProjectMilestoneDTO> getProjectBacklog(Long projectId);

	ProjectMilestoneDTO updateMilestoneStatus(Long milestoneId, String status);

	void deleteMilestone(Long milestoneId);
}