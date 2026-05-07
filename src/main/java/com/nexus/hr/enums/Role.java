package com.nexus.hr.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Role {

	// SYSTEM ROLES
	SUPER_ADMIN,
	ADMIN,

	// HR DEPARTMENT
	HR_MANAGER,
	HR_EXECUTIVE,
	HR_ASSISTANT,

	// MANAGEMENT
	CEO,
	CTO,
	COO,
	DIRECTOR,
	MANAGER,
	TEAM_LEAD,

	// TECH ROLES
	SENIOR_DEVELOPER,
	DEVELOPER,
	JUNIOR_DEVELOPER,
	INTERN_DEVELOPER,

	// QA / TESTING
	QA_MANAGER,
	QA_ENGINEER,
	TESTER,

	// PROJECT & OPERATIONS
	PROJECT_MANAGER,
	SCRUM_MASTER,
	BUSINESS_ANALYST,

	// FINANCE
	FINANCE_MANAGER,
	ACCOUNTANT,

	// SUPPORT
	SUPPORT_ENGINEER,
	CUSTOMER_SUPPORT,

	// GENERAL
	EMPLOYEE;

	@JsonCreator
	public static Role fromValue(String value) {

		if (value == null || value.trim().isEmpty()) {
			throw new IllegalArgumentException("Role cannot be null or empty");
		}

		String formatted = value.trim()
				.toUpperCase().replace(" ", "_");

		try {
			return Role.valueOf(formatted);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Invalid Role: " + value);
		}
	}
}