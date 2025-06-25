package com.portal.employeeportal.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressRequestDto {
    private Long id;
    @NotBlank(message = "house name should not be empty")
    private String houseName;
    private String laneOne;
    private String laneTwo;
    private String landMark;
    @NotBlank(message = "zip code can't be passed empty")
    private String zipCode;
}
