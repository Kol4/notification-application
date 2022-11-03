package com.notification.registrationservice.exception;

import com.notification.registrationservice.exception.exceptions.BadRequestErrorDto;
import com.notification.registrationservice.exception.exceptions.FieldDto;
import com.notification.registrationservice.exception.exceptions.InternalServerErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<InternalServerErrorDto> onUnexpectedError(Exception exception) {

        String errorUUID = UUID.randomUUID().toString();
        log.error(errorUUID, exception);

        InternalServerErrorDto internalServerErrorDto = new InternalServerErrorDto();
        internalServerErrorDto.setSupportId(errorUUID);
        internalServerErrorDto.setErrorMessage("Unexpected error occurred. Please contact the customer support.");

        return ResponseEntity.status(internalServerErrorDto.getErrorCode()).body(internalServerErrorDto);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        Set<FieldDto> fields = ex.getBindingResult().getFieldErrors().stream()
                                 .map(fieldError -> new FieldDto(fieldError.getField(), fieldError.getDefaultMessage()))
                                 .collect(Collectors.toSet());
        log.error("Bad request: {}", fields);
        return ResponseEntity.badRequest().body(new BadRequestErrorDto(fields));
    }
}
