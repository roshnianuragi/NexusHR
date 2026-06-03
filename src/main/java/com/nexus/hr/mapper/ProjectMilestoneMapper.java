package com.nexus.hr.mapper;

import com.nexus.hr.dto.ProjectMilestoneDTO;
import com.nexus.hr.enums.MilestoneStatus;
import com.nexus.hr.model.Project;
import com.nexus.hr.model.ProjectMilestone;

public class ProjectMilestoneMapper {

	// ENTITY -> DTO

	public static ProjectMilestoneDTO mapToDTO(ProjectMilestone milestone) {

		ProjectMilestoneDTO dto = new ProjectMilestoneDTO();

		dto.setId(milestone.getId());

		dto.setTitle(milestone.getTitle());

		dto.setDescription(milestone.getDescription());

		dto.setStartDate(milestone.getStartDate());

		dto.setEndDate(milestone.getEndDate());

		dto.setStatus(milestone.getStatus().name());

		dto.setProjectId(milestone.getProject().getId());

		return dto;
	}

	// DTO -> ENTITY

	public static ProjectMilestone mapToEntity(ProjectMilestoneDTO dto, Project project) {

		ProjectMilestone milestone = new ProjectMilestone();

		milestone.setTitle(dto.getTitle());

		milestone.setDescription(dto.getDescription());

		milestone.setStartDate(dto.getStartDate());

		milestone.setEndDate(dto.getEndDate());

		milestone.setStatus(MilestoneStatus.valueOf(dto.getStatus()));

		milestone.setProject(project);

		return milestone;
	}
}