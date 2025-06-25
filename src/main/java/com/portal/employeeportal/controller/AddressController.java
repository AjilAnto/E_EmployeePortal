package com.portal.employeeportal.controller;

import com.portal.employeeportal.dto.response.AddressResponseDto;
import com.portal.employeeportal.dto.response.ResponseDTO;
import com.portal.employeeportal.service.AddressService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/address")
@Validated
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("/fetchAddresses")
    public ResponseEntity<ResponseDTO<Object>> fetchAddressesByEmployeeId(@RequestParam(value = "employeeId") String employeeId) {
        if (StringUtils.isNotBlank(employeeId)) {
            Long empId = Long.parseLong(employeeId);
            List<AddressResponseDto> addressResponseDtoList = addressService.fetchAddressListByEmployeeId(empId);
            return ResponseEntity.ok(new ResponseDTO<>(addressResponseDtoList));
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ResponseDTO<>("employee id can't be empty"));
    }

}
