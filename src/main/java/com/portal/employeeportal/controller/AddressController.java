package com.portal.employeeportal.controller;

import com.portal.employeeportal.dto.request.EmployeeRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/address")
public class AddressController {

    @PostMapping("/addAddress")
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeRequestDto employeeRequestDto) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
