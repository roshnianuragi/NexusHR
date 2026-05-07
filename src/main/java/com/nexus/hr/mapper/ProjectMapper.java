package com.nexus.hr.mapper;

import java.time.LocalDate;

import com.nexus.hr.dto.ProjectDTO;
import com.nexus.hr.model.Project;

public class ProjectMapper {

	// DTO → ENTITY
	public static Project mapToEntity(ProjectDTO dto) {

		if (dto == null)
			return null;

		Project p = new Project();

		p.setId(dto.getId());
		p.setProjectName(dto.getProjectName());
		p.setClientName(dto.getClientName());
		p.setStatus(dto.getStatus());

		// SAFE DATE HANDLING
		p.setStartDate(dto.getStartDate());
		p.setEndDate(dto.getEndDate());

		return p;
	}

	// ENTITY → DTO
	public static ProjectDTO mapToDTO(Project p) {

		if (p == null)
			return null;

		ProjectDTO dto = new ProjectDTO();

		dto.setId(p.getId());
		dto.setProjectName(p.getProjectName());
		dto.setClientName(p.getClientName());
		dto.setStatus(p.getStatus());

		dto.setStartDate(p.getStartDate());
		dto.setEndDate(p.getEndDate());

		return dto;
	}
}