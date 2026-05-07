package com.nexus.hr.dto;

public class DocumentDTO {

	private Long id;
	private String documentName;
	private String documentType;
	private String fileUrl;

	private Long employeeId;

	// GETTERS & SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "DocumentDTO{" + "id=" + id + ", documentName='" + documentName + '\'' + ", documentType='"
				+ documentType + '\'' + ", fileUrl='" + fileUrl + '\'' + ", employeeId=" + employeeId + '}';
	}
}