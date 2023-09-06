package com.tenant.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({Exception.class, RuntimeException.class})
    public ResponseEntity<ApiResponse> handleGenericException(Exception ex) {
        ex.printStackTrace();
        ApiResponse response = ApiResponse.builder().error(ex.getLocalizedMessage()).build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler({AppException.class})
    public ResponseEntity<ApiResponse> handleAppException(AppException ex) {
        ApiResponse response = null;
        if(ex.getMessages() != null){
            response = ApiResponse.builder().error(ex.getMessages()).build();
        } else {
            response = ApiResponse.builder().error(ex.getMessage()).build();
        }
        return ResponseEntity.status(ex.getStatus()).body(response);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ApiResponse> handleValidationException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<String> errorList = new ArrayList<>();
        bindingResult.getFieldErrors().forEach(error -> errorList.add(error.getField()+": "+ error.getDefaultMessage()) );
        ApiResponse response = ApiResponse.builder().error(errorList).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
