package com.nexus.hr.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.nexus.hr.dto.ProjectMilestoneDTO;
import com.nexus.hr.service.ProjectMilestoneService;

@RestController
@RequestMapping("/api/projects")
public class ProjectMilestoneController {

	private final ProjectMilestoneService projectMilestoneService;

	public ProjectMilestoneController(ProjectMilestoneService projectMilestoneService) {

		this.projectMilestoneService = projectMilestoneService;
	}

	// CREATE MILESTONE

	@PostMapping("/milestone")
	public ProjectMilestoneDTO createMilestone(@RequestBody ProjectMilestoneDTO dto) {

		return projectMilestoneService.createMilestone(dto);
	}

	// PROJECT BACKLOG

	@GetMapping("/{projectId}/backlog")
	public List<ProjectMilestoneDTO> getBacklog(@PathVariable Long projectId) {

		return projectMilestoneService.getProjectBacklog(projectId);
	}

	// UPDATE STATUS

	@PutMapping("/milestone/{id}/status")
	public ProjectMilestoneDTO updateStatus(@PathVariable Long id, @RequestParam String status) {

		return projectMilestoneService.updateMilestoneStatus(id, status);
	}

	// DELETE

	@DeleteMapping("/milestone/{id}")
	public String deleteMilestone(@PathVariable Long id) {

		projectMilestoneService.deleteMilestone(id);

		return "Milestone deleted successfully";
	}
}