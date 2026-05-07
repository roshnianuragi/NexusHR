package com.nexus.hr.mapper;

import com.nexus.hr.dto.AssignmentDTO;
import com.nexus.hr.model.Assignment;
import com.nexus.hr.model.Employee;
import com.nexus.hr.model.Project;

public class AssignmentMapper {

	// DTO → ENTITY
	public static Assignment mapToEntity(AssignmentDTO dto, Employee emp, Project project) {

		if (dto == null)
			return null;

		Assignment a = new Assignment();

		a.setId(dto.getId());
		a.setRole(dto.getRole());

		a.setEmployee(emp);
		a.setProject(project);

		return a;
	}

	// ENTITY → DTO
	public static AssignmentDTO mapToDTO(Assignment a) {

		if (a == null)
			return null;

		AssignmentDTO dto = new AssignmentDTO();

		dto.setId(a.getId());
		dto.setRole(a.getRole());

		if (a.getEmployee() != null)
			dto.setEmployeeId(a.getEmployee().getId());

		if (a.getProject() != null)
			dto.setProjectId(a.getProject().getId());

		return dto;
	}
}