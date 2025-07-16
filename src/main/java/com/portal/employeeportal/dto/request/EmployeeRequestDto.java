package com.portal.employeeportal.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeRequestDto {
    private Long id;
    @NotBlank(message = "name can't be null / empty")
    private String name;
    private int age;
    private String designation;
    private List<AddressRequestDto> addressRequestDtoList;
}
