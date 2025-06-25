package com.portal.employeeportal.controller;

import com.portal.employeeportal.dto.request.EmployeeRequestDto;
import com.portal.employeeportal.dto.response.*;
import com.portal.employeeportal.exception.BadRequestException;
import com.portal.employeeportal.service.*;
import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


/**
 * @author Ajil Anto
 * addEmployee
 */
@RestController
@RequestMapping("/employee")
@Validated
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public ResponseEntity<ResponseDTO<Object>> addEmployee(@Valid @RequestBody EmployeeRequestDto employeeRequestDto) throws Exception {
        return ResponseEntity.ok(new ResponseDTO<>("employee saved successfully", employeeService.saveEmployee(employeeRequestDto)));
    }

    @DeleteMapping("/deleteEmployee")
    public ResponseEntity<ResponseDTO<Object>> removeEmployee(@RequestParam(value = "employeeId") String employeeId) {
        if (StringUtils.isNotBlank(employeeId)) {
            Long empId = Long.parseLong(employeeId);
            Boolean deletionStatus = employeeService.removeEmployee(empId);
            if (Boolean.TRUE.equals(deletionStatus)) {
                return ResponseEntity.ok(new ResponseDTO<>("employee Removed SuccessFully", Boolean.TRUE));
            } else {
                throw new BadRequestException("failed to remove employee");
            }
        } else {
            throw new BadRequestException("please enter valid employee Id");
        }
    }
}
