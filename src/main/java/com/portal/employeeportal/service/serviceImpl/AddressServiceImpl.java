package com.portal.employeeportal.service.serviceImpl;

import com.portal.employeeportal.dto.response.AddressResponseDto;
import com.portal.employeeportal.entity.Address;
import com.portal.employeeportal.exception.ItemNotFoundException;
import com.portal.employeeportal.repository.AddressRepository;
import com.portal.employeeportal.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<AddressResponseDto> fetchAddressListByEmployeeId(Long employeeId) {
        List<Address> addressList = addressRepository.findByEmployeeId(employeeId);
        if (!CollectionUtils.isEmpty(addressList)) {
            return addressList.stream()
                    .map(address ->
                            new AddressResponseDto(address.getHouseName(),address.getZipCode())
                    )
                    .collect(Collectors.toList());
        } else {
            throw new ItemNotFoundException("No Addresses found for this employee");
        }
    }
}
