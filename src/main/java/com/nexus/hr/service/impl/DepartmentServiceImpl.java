package com.nexus.hr.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nexus.hr.dto.DepartmentDTO;
import com.nexus.hr.exception.ResourceNotFoundException;
import com.nexus.hr.mapper.DepartmentMapper;
import com.nexus.hr.model.Department;
import com.nexus.hr.repository.DepartmentRepository;
import com.nexus.hr.service.DepartmentService;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	private final DepartmentRepository departmentRepository;

	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	// CREATE DEPARTMENT
	@Override
	public DepartmentDTO createDepartment(DepartmentDTO dto) {

		Department dept = DepartmentMapper.mapToEntity(dto);

		Department saved = departmentRepository.save(dept);

		return DepartmentMapper.mapToDTO(saved);
	}

	// GET BY ID
	@Override
	public DepartmentDTO getDepartmentById(Long id) {

		Department dept = departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));

		return DepartmentMapper.mapToDTO(dept);
	}

	// GET ALL
	@Override
	public List<DepartmentDTO> getAllDepartments() {

		return departmentRepository.findAll().stream().map(DepartmentMapper::mapToDTO).collect(Collectors.toList());
	}

	// UPDATE DEPARTMENT (SAFE UPDATE)
	@Override
	public DepartmentDTO updateDepartment(Long id, DepartmentDTO dto) {

		Department dept = departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));

		if (dto.getName() != null)
			dept.setName(dto.getName());

		if (dto.getLocation() != null)
			dept.setLocation(dto.getLocation());

		if (dto.getBudget() != 0)
			dept.setBudget(dto.getBudget());

		if (dto.getHeadOfDepartment() != null)
			dept.setHeadOfDepartment(dto.getHeadOfDepartment());

		if (dto.getDescription() != null && !dto.getDescription().isBlank())
			dept.setDescription(dto.getDescription());

		dept.setActive(dto.isActive());

		Department updated = departmentRepository.save(dept);

		return DepartmentMapper.mapToDTO(updated);
	}

	// DELETE
	@Override
	public void deleteDepartment(Long id) {

		Department dept = departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));

		departmentRepository.delete(dept);
	}

	// GET EMPLOYEES OF DEPARTMENT
	@Override
	public List<?> getEmployeesByDepartment(Long departmentId) {

		Department dept = departmentRepository.findById(departmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + departmentId));

		return dept.getEmployees();
	}
}