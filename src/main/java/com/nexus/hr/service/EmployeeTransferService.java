package com.nexus.hr.service;

import java.util.List;
import com.nexus.hr.dto.EmployeeTransferDTO;

public interface EmployeeTransferService {

	EmployeeTransferDTO transferEmployee(Long employeeId, EmployeeTransferDTO dto);

	List<EmployeeTransferDTO> getTransferHistory(Long employeeId);
}