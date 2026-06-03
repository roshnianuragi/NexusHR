package com.nexus.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexus.hr.enums.MilestoneStatus;
import com.nexus.hr.model.ProjectMilestone;

public interface ProjectMilestoneRepository extends JpaRepository<ProjectMilestone, Long> {

	List<ProjectMilestone> findByProjectId(Long projectId);

	List<ProjectMilestone> findByStatus(MilestoneStatus status);
}