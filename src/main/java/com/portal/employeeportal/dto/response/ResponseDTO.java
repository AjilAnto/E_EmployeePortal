package com.portal.employeeportal.dto.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO<T> {
    private Boolean status = Boolean.TRUE;
    private T result;
    private String message;
    private HttpStatus httpStatus;

    public ResponseDTO(String message, Boolean status) {
        this.message=message;
        this.status=status;
    }

    public ResponseDTO(String message, T result) {
        this.message=message;
        this.result=result;
    }
  
    public ResponseDTO(T result) {
        this.result = result;
    }
}
