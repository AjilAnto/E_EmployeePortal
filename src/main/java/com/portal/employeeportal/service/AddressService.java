package com.portal.employeeportal.service;

import com.portal.employeeportal.dto.response.AddressResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {

    List<AddressResponseDto> fetchAddressListByEmployeeId(Long employeeId);
}
