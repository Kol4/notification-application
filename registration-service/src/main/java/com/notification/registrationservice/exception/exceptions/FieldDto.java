package com.notification.registrationservice.exception.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FieldDto {
	private String field;
	private String msg;
}
