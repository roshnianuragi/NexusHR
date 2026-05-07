package com.nexus.hr.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.nexus.hr.dto.DocumentDTO;
import com.nexus.hr.service.DocumentService;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

	private final DocumentService service;

	public DocumentController(DocumentService service) {
		this.service = service;
	}

	// UPLOAD DOCUMENT
	@PostMapping
	public DocumentDTO upload(@RequestBody DocumentDTO dto) {
		return service.upload(dto);
	}

	// GET DOCUMENTS BY EMPLOYEE
	@GetMapping("/employee/{employeeId}")
	public List<DocumentDTO> getByEmployee(@PathVariable Long employeeId) {
		return service.getByEmployee(employeeId);
	}

	// DELETE DOCUMENT
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		service.delete(id);
		return "Document deleted successfully";
	}
}