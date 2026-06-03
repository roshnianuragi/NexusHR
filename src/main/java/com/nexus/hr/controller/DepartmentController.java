package com.nexus.hr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.nexus.hr.dto.DepartmentDTO;
import com.nexus.hr.service.DepartmentService;
import com.nexus.hr.response.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

	private final DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	// CREATE DEPARTMENT
	@PostMapping
	public ApiResponse<DepartmentDTO> create(@Valid @RequestBody DepartmentDTO dto) {

		return new ApiResponse<>(true, "Department created successfully", departmentService.createDepartment(dto));
	}

	// GET DEPARTMENT BY ID
	@GetMapping("/{id}")
	public ApiResponse<DepartmentDTO> getById(@PathVariable Long id) {

		return new ApiResponse<>(true, "Department fetched successfully", departmentService.getDepartmentById(id));
	}

	// GET ALL DEPARTMENTS
	@GetMapping
	public ApiResponse<List<DepartmentDTO>> getAll() {

		return new ApiResponse<>(true, "All departments fetched successfully", departmentService.getAllDepartments());
	}

	// PAGINATION
	@GetMapping("/page")
	public ApiResponse<Page<DepartmentDTO>> getDepartments(Pageable pageable) {

		return new ApiResponse<>(true, "Departments fetched with pagination",
				departmentService.getDepartments(pageable));
	}

	// UPDATE DEPARTMENT
	@PutMapping("/{id}")
	public ApiResponse<DepartmentDTO> update(@PathVariable Long id, @Valid @RequestBody DepartmentDTO dto) {

		return new ApiResponse<>(true, "Department updated successfully", departmentService.updateDepartment(id, dto));
	}

	// DELETE DEPARTMENT
	@DeleteMapping("/{id}")
	public ApiResponse<String> delete(@PathVariable Long id) {

		departmentService.deleteDepartment(id);

		return new ApiResponse<>(true, "Department deleted successfully", null);
	}

	// GET EMPLOYEES OF DEPARTMENT
	@GetMapping("/{id}/employees")
	public ApiResponse<List<?>> getEmployees(@PathVariable Long id) {

		return new ApiResponse<>(true, "Employees of department fetched successfully",
				departmentService.getEmployeesByDepartment(id));
	}

	// SEARCH BY NAME
	@GetMapping("/search/name")
	public ApiResponse<List<DepartmentDTO>> searchByName(@RequestParam String name) {

		return new ApiResponse<>(true, "Departments found by name", departmentService.searchByName(name));
	}

	// SEARCH BY LOCATION
	@GetMapping("/search/location")
	public ApiResponse<List<DepartmentDTO>> searchByLocation(@RequestParam String location) {

		return new ApiResponse<>(true, "Departments found by location", departmentService.searchByLocation(location));
	}

	// GET ACTIVE DEPARTMENTS
	@GetMapping("/active")
	public ApiResponse<List<DepartmentDTO>> getActiveDepartments() {

		return new ApiResponse<>(true, "Active departments fetched successfully",
				departmentService.getActiveDepartments());
	}

	// BULK SALARY RAISE
	@PutMapping("/{id}/raise")
	public ApiResponse<String> raiseDepartmentSalary(@PathVariable Long id, @RequestParam double percentage) {

		departmentService.raiseDepartmentSalary(id, percentage);

		return new ApiResponse<>(true, "Salary updated successfully by " + percentage + "%", null);
	}

	// DEPARTMENT ANALYTICS
	@GetMapping("/{id}/stats")
	public ApiResponse<Map<String, Object>> getDepartmentStats(@PathVariable Long id) {

		Map<String, Object> stats = new HashMap<>();

		stats.put("totalEmployees", departmentService.getTotalEmployees(id));
		stats.put("totalSalary", departmentService.getTotalSalary(id));
		stats.put("genderRatio", departmentService.getGenderRatio(id));

		return new ApiResponse<>(true, "Department statistics fetched successfully", stats);
	}
}