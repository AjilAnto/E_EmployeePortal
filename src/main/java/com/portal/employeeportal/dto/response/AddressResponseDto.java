package com.portal.employeeportal.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressResponseDto {
    private Long id;
    private String houseName;
    private String laneOne;
    private String laneTwo;
    private String landMark;
    private String zipCode;
}
