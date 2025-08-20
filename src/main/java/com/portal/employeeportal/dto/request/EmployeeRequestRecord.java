package com.portal.employeeportal.dto.request;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record EmployeeRequestRecord(
        Long id,
        @NotBlank(message = "name can't be null / empty")
        String name,
        int age,
        String designation,
        List<AddressRequestDto> addressRequestDtoList) {

    @Override
    public Long id() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int age() {
        return age;
    }

    @Override
    public String designation() {
        return designation;
    }

    @Override
    public List<AddressRequestDto> addressRequestDtoList() {
        return addressRequestDtoList;
    }
}
