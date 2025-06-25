package com.portal.employeeportal.repository;

import com.portal.employeeportal.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepoitory extends JpaRepository<Employee, Long> {


}
