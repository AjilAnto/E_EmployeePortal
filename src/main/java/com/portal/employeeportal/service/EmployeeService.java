package com.portal.employeeportal.service;

import com.portal.employeeportal.dto.request.EmployeeRequestRecord;
import com.portal.employeeportal.dto.response.EmployeeResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

    EmployeeResponseDto saveEmployee(EmployeeRequestRecord employeeRequestRecord) throws Exception;

    Boolean removeEmployee(Long employeeId);

}
