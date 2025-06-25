package com.portal.employeeportal.controller;

import com.portal.employeeportal.dto.request.EmployeeRequestDto;
import com.portal.employeeportal.dto.response.*;
import com.portal.employeeportal.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Ajil Anto
 * addEmployee
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public ResponseEntity<ResponseDTO<Object>> addEmployee(@RequestBody EmployeeRequestDto employeeRequestDto) throws Exception {
        return ResponseEntity.ok(new ResponseDTO<>("employee saved successfully", employeeService.saveEmployee(employeeRequestDto), HttpStatus.OK));
    }
}
