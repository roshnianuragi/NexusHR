package com.nexus.hr.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nexus.hr.dto.EmployeeDTO;
import com.nexus.hr.exception.ResourceNotFoundException;
import com.nexus.hr.mapper.EmployeeMapper;
import com.nexus.hr.model.Department;
import com.nexus.hr.model.Employee;
import com.nexus.hr.repository.DepartmentRepository;
import com.nexus.hr.repository.EmployeeRepository;
import com.nexus.hr.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;
	private final DepartmentRepository departmentRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
		this.employeeRepository = employeeRepository;
		this.departmentRepository = departmentRepository;
	}

	// CREATE
	@Override
	@Transactional
	@CacheEvict(value = "employees", allEntries = true)
	public EmployeeDTO createEmployee(EmployeeDTO dto) {

		Department dept = departmentRepository.findById(dto.getDepartmentId())
				.orElseThrow(() -> new ResourceNotFoundException("Department not found"));

		Employee emp = EmployeeMapper.mapToEntity(dto, dept);

		return EmployeeMapper.mapToDTO(employeeRepository.save(emp));
	}

	// GET BY ID
	@Override
	public EmployeeDTO getEmployeeById(Long id) {

		Employee emp = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

		return EmployeeMapper.mapToDTO(emp);
	}

	// GET ALL
	@Override
	@Cacheable("employees")
	public List<EmployeeDTO> getAllEmployees() {

		return employeeRepository.findAll().stream().map(EmployeeMapper::mapToDTO).collect(Collectors.toList());
	}

	// PAGINATION (NEW METHOD NOT IN INTERFACE OPTIONAL)
	public Page<EmployeeDTO> getEmployees(Pageable pageable) {

		Page<Employee> page = employeeRepository.findAll(pageable);

		return page.map(EmployeeMapper::mapToDTO);
	}

	// UPDATE
	@Override
	@Transactional
	@CacheEvict(value = "employees", allEntries = true)
	public EmployeeDTO updateEmployee(Long id, EmployeeDTO dto) {

		Employee emp = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

		if (dto.getFirstName() != null)
			emp.setFirstName(dto.getFirstName());

		if (dto.getLastName() != null)
			emp.setLastName(dto.getLastName());

		if (dto.getEmail() != null)
			emp.setEmail(dto.getEmail());

		if (dto.getPhone() != null)
			emp.setPhone(dto.getPhone());

		if (dto.getAge() != 0)
			emp.setAge(dto.getAge());

		if (dto.getSalary() != 0)
			emp.setSalary(dto.getSalary());

		if (dto.getDesignation() != null)
			emp.setDesignation(dto.getDesignation());

		if (dto.getDepartmentId() != null) {
			Department dept = departmentRepository.findById(dto.getDepartmentId())
					.orElseThrow(() -> new ResourceNotFoundException("Department not found"));
			emp.setDepartment(dept);
		}

		return EmployeeMapper.mapToDTO(employeeRepository.save(emp));
	}

	// DELETE
	@Override
	@Transactional
	@CacheEvict(value = "employees", allEntries = true)
	public void deleteEmployee(Long id) {

		Employee emp = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

		employeeRepository.delete(emp);
	}

	// EMAIL SEARCH
	@Override
	public EmployeeDTO getEmployeeByEmail(String email) {

		Employee emp = employeeRepository.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

		return EmployeeMapper.mapToDTO(emp);
	}

	// DEPARTMENT WISE
	@Override
	public List<EmployeeDTO> getEmployeesByDepartment(Long departmentId) {

		return employeeRepository.findByDepartmentId(departmentId).stream().map(EmployeeMapper::mapToDTO)
				.collect(Collectors.toList());
	}

	// DESIGNATION WISE
	@Override
	public List<EmployeeDTO> getEmployeesByDesignation(String designation) {

		return employeeRepository.findByDesignation(designation).stream().map(EmployeeMapper::mapToDTO)
				.collect(Collectors.toList());
	}

	// SEARCH
	@Override
	public List<EmployeeDTO> searchEmployees(String name) {

		return employeeRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(name, name).stream()
				.map(EmployeeMapper::mapToDTO).collect(Collectors.toList());
	}

	// COUNT
	@Override
	public long countEmployeesByDepartment(Long departmentId) {

		return employeeRepository.countByDepartmentId(departmentId);
	}
}