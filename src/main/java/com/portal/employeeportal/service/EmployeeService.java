package com.portal.employeeportal.service;

import com.portal.employeeportal.dto.request.EmployeeRequestDto;
import com.portal.employeeportal.dto.response.EmployeeResponseDto;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

    EmployeeResponseDto saveEmployee(EmployeeRequestDto employeeRequestDto) throws Exception;

    Boolean removeEmployee(Long employeeId);

}
