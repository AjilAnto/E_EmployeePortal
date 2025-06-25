package com.portal.employeeportal.service.serviceImpl;

import com.portal.employeeportal.dto.request.EmployeeRequestDto;
import com.portal.employeeportal.dto.response.EmployeeResponseDto;
import com.portal.employeeportal.entity.Address;
import com.portal.employeeportal.entity.Employee;
import com.portal.employeeportal.exception.BadRequestException;
import com.portal.employeeportal.exception.ItemNotFoundException;
import com.portal.employeeportal.repository.*;
import com.portal.employeeportal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepoitory employeeRepoitory;


    @Transactional
    @Override
    public EmployeeResponseDto saveEmployee(EmployeeRequestDto employeeRequestDto) throws Exception {
        try {
            EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
            if (Objects.nonNull(employeeRequestDto)) {
                Employee employee = new Employee();
                employee.setName(employeeRequestDto.getName());
                employee.setAge(employeeRequestDto.getAge());
                employee.setDesignation(employeeRequestDto.getDesignation());

                List<Address> addressList = employeeRequestDto.getAddressRequestDtoList()
                        .stream().map(addressRequestDto -> {
                            Address address = new Address();
                            address.setHouseName(addressRequestDto.getHouseName());
                            address.setLaneOne(addressRequestDto.getLaneOne());
                            address.setLaneTwo(addressRequestDto.getLaneTwo());
                            address.setLandMark(addressRequestDto.getLandMark());
                            address.setZipCode(addressRequestDto.getZipCode());
                            address.setEmployee(employee);
                            return address;
                        })
                        .collect(Collectors.toList());

                employee.setAddressList(addressList);
                Employee savedEmployee = employeeRepoitory.save(employee);
                employeeResponseDto.setEid(savedEmployee.getId());
                employeeResponseDto.setName(savedEmployee.getName());
//                employeeResponseDto.setAddressRequestDtoList(savedEmployee.getAddressList());
            }
            return employeeResponseDto;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Boolean removeEmployee(Long employeeId) {
        if (employeeRepoitory.existsById(employeeId)) {
            employeeRepoitory.deleteById(employeeId);
            employeeRepoitory.flush();
            return !employeeRepoitory.existsById(employeeId);
        } else {
            throw new ItemNotFoundException("employee doesn't exists, please try again with valid employeeId");
        }
    }
}
