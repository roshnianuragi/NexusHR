package com.nexus.hr.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nexus.hr.dto.DepartmentDTO;
import com.nexus.hr.exception.ResourceNotFoundException;
import com.nexus.hr.mapper.DepartmentMapper;
import com.nexus.hr.model.Department;
import com.nexus.hr.model.Employee;
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

		Department savedDepartment = departmentRepository.save(dept);

		return DepartmentMapper.mapToDTO(savedDepartment);
	}

	// GET DEPARTMENT BY ID

	@Override
	public DepartmentDTO getDepartmentById(Long id) {

		Department dept = departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));

		return DepartmentMapper.mapToDTO(dept);
	}

	// GET ALL DEPARTMENTS

	@Override
	public List<DepartmentDTO> getAllDepartments() {

		return departmentRepository.findAll().stream().map(DepartmentMapper::mapToDTO).collect(Collectors.toList());
	}

	// PAGINATION

	@Override
	public Page<DepartmentDTO> getDepartments(Pageable pageable) {

		Page<Department> departments = departmentRepository.findAll(pageable);

		return departments.map(DepartmentMapper::mapToDTO);
	}

	// UPDATE DEPARTMENT

	@Override
	public DepartmentDTO updateDepartment(Long id, DepartmentDTO dto) {

		Department dept = departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));

		// UPDATE FIELDS

		if (dto.getName() != null) {
			dept.setName(dto.getName());
		}

		if (dto.getLocation() != null) {
			dept.setLocation(dto.getLocation());
		}

		if (dto.getBudget() != 0) {
			dept.setBudget(dto.getBudget());
		}

		if (dto.getDescription() != null && !dto.getDescription().isBlank()) {

			dept.setDescription(dto.getDescription());
		}

		if (dto.getHeadOfDepartment() != null) {
			dept.setHeadOfDepartment(dto.getHeadOfDepartment());
		}

		dept.setActive(dto.isActive());

		Department updatedDepartment = departmentRepository.save(dept);

		return DepartmentMapper.mapToDTO(updatedDepartment);
	}

	// DELETE DEPARTMENT

	@Override
	public void deleteDepartment(Long id) {

		Department dept = departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));

		// VALIDATION

		if (dept.getEmployees() != null && !dept.getEmployees().isEmpty()) {

			throw new RuntimeException("Employees are still assigned to this department");
		}

		departmentRepository.delete(dept);
	}

	// GET EMPLOYEES OF DEPARTMENT

	@Override
	public List<?> getEmployeesByDepartment(Long departmentId) {

		Department dept = departmentRepository.findById(departmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + departmentId));

		return dept.getEmployees();
	}

	// SEARCH BY NAME

	@Override
	public List<DepartmentDTO> searchByName(String name) {

		return departmentRepository.findByNameContainingIgnoreCase(name).stream().map(DepartmentMapper::mapToDTO)
				.collect(Collectors.toList());
	}

	// SEARCH BY LOCATION

	@Override
	public List<DepartmentDTO> searchByLocation(String location) {

		return departmentRepository.findByLocationContainingIgnoreCase(location).stream()
				.map(DepartmentMapper::mapToDTO).collect(Collectors.toList());
	}

	// ACTIVE DEPARTMENTS

	@Override
	public List<DepartmentDTO> getActiveDepartments() {

		return departmentRepository.findByActiveTrue().stream().map(DepartmentMapper::mapToDTO)
				.collect(Collectors.toList());
	}

	// BULK SALARY RAISE

	@Override
	public void raiseDepartmentSalary(Long departmentId, double percentage) {

		Department dept = departmentRepository.findById(departmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Department not found"));

		List<Employee> employees = dept.getEmployees();

		for (Employee employee : employees) {

			double currentSalary = employee.getSalary();

			double increasedSalary = currentSalary + (currentSalary * percentage / 100);

			employee.setSalary(increasedSalary);
		}
	}

	// TOTAL EMPLOYEES

	@Override
	public long getTotalEmployees(Long departmentId) {

		Department dept = departmentRepository.findById(departmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Department not found"));

		return dept.getEmployees().size();
	}

	// TOTAL SALARY

	@Override
	public double getTotalSalary(Long departmentId) {

		Department dept = departmentRepository.findById(departmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Department not found"));

		return dept.getEmployees().stream().mapToDouble(Employee::getSalary).sum();
	}

	// GENDER RATIO

	@Override
	public String getGenderRatio(Long departmentId) {

		Department dept = departmentRepository.findById(departmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Department not found"));

		long maleCount = dept.getEmployees().stream().filter(emp -> "MALE".equalsIgnoreCase(emp.getGender())).count();

		long femaleCount = dept.getEmployees().stream().filter(emp -> "FEMALE".equalsIgnoreCase(emp.getGender()))
				.count();

		return "Male: " + maleCount + " | Female: " + femaleCount;
	}
}