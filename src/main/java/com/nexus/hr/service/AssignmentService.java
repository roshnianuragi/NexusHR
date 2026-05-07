package com.nexus.hr.service;

import java.util.List;
import com.nexus.hr.dto.AssignmentDTO;

public interface AssignmentService {

	AssignmentDTO assignEmployee(AssignmentDTO dto);

	List<AssignmentDTO> getAll();

	void remove(Long id);
}