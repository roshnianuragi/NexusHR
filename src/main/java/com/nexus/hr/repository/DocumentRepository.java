package com.nexus.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexus.hr.model.Document;
import com.nexus.hr.model.Employee;

public interface DocumentRepository extends JpaRepository<Document, Long> {

	// THIS IS REQUIRED
	List<Document> findByEmployee(Employee employee);
}