package com.nexus.hr.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nexus.hr.dto.DocumentDTO;
import com.nexus.hr.exception.ResourceNotFoundException;
import com.nexus.hr.mapper.DocumentMapper;
import com.nexus.hr.model.Document;
import com.nexus.hr.model.Employee;
import com.nexus.hr.repository.DocumentRepository;
import com.nexus.hr.repository.EmployeeRepository;
import com.nexus.hr.service.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService {

	private final DocumentRepository docRepo;
	private final EmployeeRepository empRepo;

	public DocumentServiceImpl(DocumentRepository docRepo, EmployeeRepository empRepo) {
		this.docRepo = docRepo;
		this.empRepo = empRepo;
	}

	// UPLOAD DOCUMENT
	@Override
	public DocumentDTO upload(DocumentDTO dto) {

		Employee emp = empRepo.findById(dto.getEmployeeId())
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

		Document doc = DocumentMapper.mapToEntity(dto, emp);

		Document saved = docRepo.save(doc);

		return DocumentMapper.mapToDTO(saved);
	}

	// GET BY EMPLOYEE
	@Override
	public List<DocumentDTO> getByEmployee(Long employeeId) {

		Employee emp = empRepo.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

		List<Document> docs = docRepo.findByEmployee(emp);

		return docs.stream().map(DocumentMapper::mapToDTO).collect(Collectors.toList());
	}

	// DELETE DOCUMENT
	@Override
	public void delete(Long id) {

		Document doc = docRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Document not found"));

		docRepo.delete(doc);
	}
}