package com.nexus.hr.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexus.hr.model.Employee;
import com.nexus.hr.model.LeaveBalance;

public interface LeaveBalanceRepository extends JpaRepository<LeaveBalance, Long> {

	Optional<LeaveBalance> findByEmployee(Employee employee);
}