package com.portal.employeeportal.controller;

import com.portal.employeeportal.dto.response.AddressResponseDto;
import com.portal.employeeportal.dto.response.ResponseDTO;
import com.portal.employeeportal.exception.BadRequestException;
import com.portal.employeeportal.service.AddressService;
import io.micrometer.common.util.StringUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/address")
@Validated
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("/fetchActiveAddresses")
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

    @PatchMapping("/disableAddress")
    public ResponseEntity<ResponseDTO<Object>> disableAddressesByIds(@Valid @RequestBody List<Long> addressIds) {
        if (!CollectionUtils.isEmpty(addressIds)) {
            Boolean disableStatus = addressService.disableAddressesByIds(addressIds);
            if (Boolean.TRUE.equals(disableStatus)) {
                return ResponseEntity.ok(new ResponseDTO<>("Address disabled successfully"));
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO<>("error while updating address"));
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO<>("address ids can't be empty"));
        }
    }
}
