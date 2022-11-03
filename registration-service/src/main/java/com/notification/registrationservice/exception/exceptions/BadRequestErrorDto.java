package com.notification.registrationservice.exception.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Set;

@Getter
public class BadRequestErrorDto extends HttpErrorDto {
	private final Set<FieldDto> fields;

	public BadRequestErrorDto(Set<FieldDto> fields){
		super(HttpStatus.BAD_REQUEST);
		this.fields = fields;
	}
}
