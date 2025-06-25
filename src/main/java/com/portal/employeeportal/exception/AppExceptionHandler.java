package com.portal.employeeportal.exception;

import com.portal.employeeportal.dto.response.ResponseDTO;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ResponseDTO<Object>> handleException (Exception e, WebRequest webRequest) {
        ResponseDTO<Object> responseDTO = ResponseDTO
                .builder()
                .status(Boolean.FALSE)
                .message(e.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDTO);
    }


    @ExceptionHandler({BadRequestException.class,ItemNotFoundException.class, ConstraintViolationException.class})
    public ResponseEntity<ResponseDTO<Object>> handleCustomExceptions(Exception e, WebRequest webRequest) {
        ResponseDTO<Object> responseDTO = ResponseDTO
                .builder()
                .status(Boolean.FALSE)
                .message(e.getMessage())
                .build();
        if(e instanceof ItemNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTO);
        }
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ResponseDTO<Object>> handleFieldValidation(MethodArgumentNotValidException e, WebRequest webRequest) {
        List<FieldError> fieldErrors =e.getBindingResult().getFieldErrors();
        ResponseDTO<Object> responseDTO = ResponseDTO
                .builder()
                .status(Boolean.FALSE)
                .result(fieldErrors.stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList())
                .message(fieldErrors.get(0).getDefaultMessage())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTO);
    }

}
