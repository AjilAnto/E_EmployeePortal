package com.portal.employeeportal.service.serviceImpl;

import com.portal.employeeportal.dto.request.EmployeeRequestDto;
import com.portal.employeeportal.dto.response.EmployeeResponseDto;
import com.portal.employeeportal.entity.Address;
import com.portal.employeeportal.entity.Employee;
import com.portal.employeeportal.exception.BadRequestException;
import com.portal.employeeportal.exception.ItemNotFoundException;
import com.portal.employeeportal.fuctional.EmployeeFunctional;
import com.portal.employeeportal.repository.EmployeeRepository;
import com.portal.employeeportal.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import utility.LoggerManager;

import java.util.List;
import java.util.Objects;

@Component
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Transactional
    @Override
    public EmployeeResponseDto saveEmployee(EmployeeRequestDto employeeRequestDto) {
        LoggerManager.infoLogger("inside saveEmployee", this.getClass());
        try {
            EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
            if (Objects.nonNull(employeeRequestDto)) {
                Employee employee = new Employee();
                if (EmployeeFunctional.isEmployeeNameValid(employeeRequestDto.getName())) {
                    employee.setName(employeeRequestDto.getName());
                } else throw new BadRequestException("name can't contain Special characters");
                if (EmployeeFunctional.isAgeValid(employeeRequestDto.getAge())) {
                    employee.setAge(employeeRequestDto.getAge());
                } else throw new BadRequestException("please try with valid age, " +
                        "age should be greater than 18 and less than 100");
                employee.setDesignation(employeeRequestDto.getDesignation());
                List<Address> addressList = employeeRequestDto.getAddressRequestDtoList()
                        .stream().map(addressRequestDto ->
                            modelMapper.map(addressRequestDto,Address.class)).toList();

                employee.setAddressList(addressList);
                Employee savedEmployee = employeeRepository.save(employee);
                employeeResponseDto.setEid(savedEmployee.getId());
                employeeResponseDto.setName(savedEmployee.getName());
            } else {
                throw new BadRequestException("Request cannot be null");
            }
            return employeeResponseDto;
        }catch (BadRequestException b){
            LoggerManager.errorLogger(b.getLocalizedMessage(),this.getClass());
            throw new BadRequestException((b.getMessage()));
        }catch (Exception e){
            LoggerManager.errorLogger("Unexpected exception: {} "+e.getLocalizedMessage(),this.getClass());
            throw new RuntimeException("Error saving employee", e);
        }
    }

    @Override
    public Boolean removeEmployee(Long employeeId) {
        if (employeeRepository.existsById(employeeId)) {
            employeeRepository.deleteById(employeeId);
            employeeRepository.flush();
            return !employeeRepository.existsById(employeeId);
        } else {
            throw new ItemNotFoundException("employee doesn't exists, please try again with valid employeeId");
        }
    }
}
