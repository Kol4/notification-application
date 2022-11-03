package com.notification.notificationsenderservice.exception.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

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
