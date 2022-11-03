package com.notification.notificationsenderservice.exception.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HttpErrorDto {

	public HttpErrorDto(int errorCode, String error) {
		this.errorCode = errorCode;
		this.error = error;
	}

	public HttpErrorDto(HttpStatus httpStatus) {
		this(httpStatus.value(), httpStatus.getReasonPhrase());
	}

	private int errorCode;
	private String error;
}
