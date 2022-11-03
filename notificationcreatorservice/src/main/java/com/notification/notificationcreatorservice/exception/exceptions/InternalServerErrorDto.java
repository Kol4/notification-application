package com.notification.notificationcreatorservice.exception.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class InternalServerErrorDto extends HttpErrorDto {
    private String errorMessage;
    private String supportId;

    public InternalServerErrorDto() {
        this(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public InternalServerErrorDto(HttpStatus httpStatus) {
        super(httpStatus);
    }
}
