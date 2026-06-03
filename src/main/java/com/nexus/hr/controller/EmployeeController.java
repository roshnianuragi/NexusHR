package com.nexus.hr.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.nexus.hr.dto.EmployeeDTO;
import com.nexus.hr.response.ApiResponse;
import com.nexus.hr.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
@Tag(name = "Employee Controller", description = "Employee Management APIs")
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// CREATE EMPLOYEE
	@PostMapping
	@Operation(summary = "Create Employee")
	public ApiResponse<EmployeeDTO> createEmployee(@Valid @RequestBody EmployeeDTO dto) {

		return new ApiResponse<>(true, "Employee created successfully", employeeService.createEmployee(dto));
	}

	// GET EMPLOYEE BY ID
	@GetMapping("/{id}")
	@Operation(summary = "Get Employee By ID")
	public ApiResponse<EmployeeDTO> getEmployeeById(@PathVariable Long id) {

		return new ApiResponse<>(true, "Employee fetched successfully", employeeService.getEmployeeById(id));
	}

	// GET ALL EMPLOYEES
	@GetMapping
	@Operation(summary = "Get All Employees")
	public ApiResponse<List<EmployeeDTO>> getAllEmployees() {

		return new ApiResponse<>(true, "All employees fetched successfully", employeeService.getAllEmployees());
	}

	// PAGINATION
	@GetMapping("/page")
	@Operation(summary = "Get Employees With Pagination")
	public ApiResponse<Page<EmployeeDTO>> getEmployees(Pageable pageable) {

		return new ApiResponse<>(true, "Employees fetched with pagination", employeeService.getEmployees(pageable));
	}

	// UPDATE EMPLOYEE
	@PutMapping("/{id}")
	@Operation(summary = "Update Employee")
	public ApiResponse<EmployeeDTO> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDTO dto) {

		return new ApiResponse<>(true, "Employee updated successfully", employeeService.updateEmployee(id, dto));
	}

	// DELETE EMPLOYEE
	@DeleteMapping("/{id}")
	@Operation(summary = "Delete Employee")
	public ApiResponse<String> deleteEmployee(@PathVariable Long id) {

		employeeService.deleteEmployee(id);

		return new ApiResponse<>(true, "Employee deleted successfully", null);
	}

	// GET EMPLOYEE BY EMAIL
	@GetMapping("/email")
	@Operation(summary = "Get Employee By Email")
	public ApiResponse<EmployeeDTO> getEmployeeByEmail(@RequestParam String email) {

		return new ApiResponse<>(true, "Employee fetched by email", employeeService.getEmployeeByEmail(email));
	}

	// GET EMPLOYEES BY DEPARTMENT
	@GetMapping("/department/{departmentId}")
	@Operation(summary = "Get Employees By Department")
	public ApiResponse<List<EmployeeDTO>> getEmployeesByDepartment(@PathVariable Long departmentId) {

		return new ApiResponse<>(true, "Employees fetched by department",
				employeeService.getEmployeesByDepartment(departmentId));
	}

	// GET EMPLOYEES BY DESIGNATION
	@GetMapping("/designation")
	@Operation(summary = "Get Employees By Designation")
	public ApiResponse<List<EmployeeDTO>> getEmployeesByDesignation(@RequestParam String designation) {

		return new ApiResponse<>(true, "Employees fetched by designation",
				employeeService.getEmployeesByDesignation(designation));
	}

	// SEARCH EMPLOYEE BY NAME
	@GetMapping("/searchByName")
	@Operation(summary = "Search Employees By Name")
	public ApiResponse<List<EmployeeDTO>> searchEmployees(@RequestParam String name) {

		return new ApiResponse<>(true, "Search results fetched", employeeService.searchEmployees(name));
	}

	// COUNT EMPLOYEES BY DEPARTMENT
	@GetMapping("/count/{departmentId}")
	@Operation(summary = "Count Employees By Department")
	public ApiResponse<Long> countEmployeesByDepartment(@PathVariable Long departmentId) {

		return new ApiResponse<>(true, "Employee count fetched",
				employeeService.countEmployeesByDepartment(departmentId));
	}

	// ADVANCED SEARCH
	@GetMapping("/search")
	@Operation(summary = "Advanced Employee Search")
	public ApiResponse<Page<EmployeeDTO>> advancedSearch(

			@RequestParam(required = false) String name, @RequestParam(required = false) Long departmentId,
			@RequestParam(required = false) String designation, @RequestParam(required = false) Double minSalary,
			@RequestParam(required = false) Double maxSalary, Pageable pageable) {

		return new ApiResponse<>(true, "Advanced search completed",
				employeeService.searchEmployees(name, departmentId, designation, minSalary, maxSalary, pageable));
	}
}