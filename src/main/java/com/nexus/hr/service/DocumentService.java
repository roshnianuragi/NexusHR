package com.nexus.hr.service;

import java.util.List;

import com.nexus.hr.dto.DocumentDTO;

public interface DocumentService {

	DocumentDTO upload(DocumentDTO dto);

	List<DocumentDTO> getByEmployee(Long employeeId);

	void delete(Long id);
}