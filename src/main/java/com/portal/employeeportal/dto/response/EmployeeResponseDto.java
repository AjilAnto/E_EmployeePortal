package com.portal.employeeportal.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.portal.employeeportal.dto.request.AddressRequestDto;
import com.portal.employeeportal.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeResponseDto {
    @JsonProperty("employeeId")
    private Long eid;
    @JsonProperty("employeeName")
    private String name;
    @JsonProperty("addresses")
    private List<Address> addressRequestDtoList;
    private int age;
    private String designation;
}
