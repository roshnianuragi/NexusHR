package com.nexus.hr.service;

import java.util.List;
import com.nexus.hr.dto.ProjectDTO;

public interface ProjectService {

	ProjectDTO create(ProjectDTO dto);

	ProjectDTO getById(Long id);

	List<ProjectDTO> getAll();

	ProjectDTO update(Long id, ProjectDTO dto);

	void delete(Long id);
}