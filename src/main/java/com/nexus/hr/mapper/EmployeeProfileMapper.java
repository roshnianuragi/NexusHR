package com.nexus.hr.mapper;

import com.nexus.hr.dto.EmployeeProfileDTO;
import com.nexus.hr.model.Employee;
import com.nexus.hr.model.EmployeeProfile;

public class EmployeeProfileMapper {

	// DTO → ENTITY
	public static EmployeeProfile mapToEntity(EmployeeProfileDTO dto, Employee emp) {

		if (dto == null)
			return null;

		EmployeeProfile profile = new EmployeeProfile();

		profile.setId(dto.getId());
		profile.setAddress(dto.getAddress());
		profile.setCity(dto.getCity());
		profile.setState(dto.getState());
		profile.setEmergencyContact(dto.getEmergencyContact());
		profile.setBloodGroup(dto.getBloodGroup());
		profile.setPanNo(dto.getPanNo());
		profile.setAadhaarNo(dto.getAadhaarNo());
		profile.setBankAccountNo(dto.getBankAccountNo());

		// 🔥 IMPORTANT: relation handled in service layer
		profile.setEmployee(emp);

		return profile;
	}

	// ENTITY → DTO
	public static EmployeeProfileDTO mapToDTO(EmployeeProfile profile) {

		if (profile == null)
			return null;

		EmployeeProfileDTO dto = new EmployeeProfileDTO();

		dto.setId(profile.getId());
		dto.setAddress(profile.getAddress());
		dto.setCity(profile.getCity());
		dto.setState(profile.getState());
		dto.setEmergencyContact(profile.getEmergencyContact());
		dto.setBloodGroup(profile.getBloodGroup());
		dto.setPanNo(profile.getPanNo());
		dto.setAadhaarNo(profile.getAadhaarNo());
		dto.setBankAccountNo(profile.getBankAccountNo());

		// ONLY ID (NO FULL OBJECT)
		if (profile.getEmployee() != null) {
			dto.setEmployeeId(profile.getEmployee().getId());
		}

		return dto;
	}
}