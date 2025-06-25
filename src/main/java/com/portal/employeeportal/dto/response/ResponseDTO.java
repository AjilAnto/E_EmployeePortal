package com.portal.employeeportal.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO<T> {
    private Boolean success = Boolean.TRUE;
    private T result;
    private String message;
    private HttpStatus httpStatus;

    public ResponseDTO(T result, Boolean success) {
        this.result = result;
        this.success = success;
    }

    public ResponseDTO(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public ResponseDTO(T result, HttpStatus httpStatus) {
        this.result = result;
        this.httpStatus = httpStatus;
    }

    public ResponseDTO(String message, T result) {
        this.message = message;
        this.result = result;
    }

    public ResponseDTO(String message, T result, HttpStatus httpStatus) {
        this.message = message;
        this.result = result;
        this.httpStatus = httpStatus;
    }

}
