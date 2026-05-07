package com.nexus.hr.mapper;

import com.nexus.hr.dto.DocumentDTO;
import com.nexus.hr.model.Document;
import com.nexus.hr.model.Employee;

public class DocumentMapper {

	// DTO → ENTITY
	public static Document mapToEntity(DocumentDTO dto, Employee emp) {

		if (dto == null)
			return null;

		Document d = new Document();

		d.setId(dto.getId());
		d.setDocumentName(dto.getDocumentName());
		d.setDocumentType(dto.getDocumentType());
		d.setFileUrl(dto.getFileUrl());
		d.setEmployee(emp);

		return d;
	}

	// ENTITY → DTO
	public static DocumentDTO mapToDTO(Document d) {

		if (d == null)
			return null;

		DocumentDTO dto = new DocumentDTO();

		dto.setId(d.getId());
		dto.setDocumentName(d.getDocumentName());
		dto.setDocumentType(d.getDocumentType());
		dto.setFileUrl(d.getFileUrl());

		if (d.getEmployee() != null) {
			dto.setEmployeeId(d.getEmployee().getId());
		}

		return dto;
	}
}