package com.notification.notificationsenderservice.exception.exceptions;

import java.util.Set;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class BadRequestErrorDto extends HttpErrorDto {

	private final Set<FieldDto> fields;

	public BadRequestErrorDto(Set<FieldDto> fields) {
		super(HttpStatus.BAD_REQUEST);
		this.fields = fields;
	}
}
