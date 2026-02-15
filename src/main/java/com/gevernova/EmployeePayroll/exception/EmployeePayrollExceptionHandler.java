package com.gevernova.EmployeePayroll.exception;


import com.gevernova.EmployeePayroll.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeePayrollExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleValidationException(
            MethodArgumentNotValidException ex) {
        return new ResponseEntity<>(
                new ResponseDTO("Validation Error",
                        ex.getBindingResult().getAllErrors()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmployeePayrollException.class)
    public ResponseEntity<ResponseDTO> handleEmployeeException(
            EmployeePayrollException ex) {
        return new ResponseEntity<>(
                new ResponseDTO("Exception", ex.getMessage()),
                HttpStatus.BAD_REQUEST);
    }
}

