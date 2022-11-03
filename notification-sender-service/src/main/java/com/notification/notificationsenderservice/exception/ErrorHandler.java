package com.notification.notificationsenderservice.exception;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.notification.notificationsenderservice.exception.exceptions.BadRequestErrorDto;
import com.notification.notificationsenderservice.exception.exceptions.FieldDto;
import com.notification.notificationsenderservice.exception.exceptions.HttpErrorDto;
import com.notification.notificationsenderservice.exception.exceptions.InternalServerErrorDto;

import de.bytefish.fcmjava.exceptions.FcmAuthenticationException;
import de.bytefish.fcmjava.exceptions.FcmException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice()
public class ErrorHandler extends ResponseEntityExceptionHandler {

	private final static String INVALID_FCM_API_KEY_MSG = "Invalid FCM Api key";

	@ExceptionHandler(Exception.class)
	public ResponseEntity<InternalServerErrorDto> onUnexpectedError(Exception exception) {

		String errorUUID = UUID.randomUUID().toString();
		log.error(errorUUID, exception);

		InternalServerErrorDto internalServerErrorDto = new InternalServerErrorDto();
		internalServerErrorDto.setSupportId(errorUUID);
		internalServerErrorDto.setErrorMessage("Unexpected error occurred. Please contact the customer support.");

		return ResponseEntity.status(internalServerErrorDto.getErrorCode()).body(internalServerErrorDto);
	}

	@ExceptionHandler(FcmAuthenticationException.class)
	public ResponseEntity<HttpErrorDto> onFcmAuthenticationException(FcmAuthenticationException exception) {
		log.error(INVALID_FCM_API_KEY_MSG);
		HttpErrorDto httpErrorDto = new HttpErrorDto(exception.getHttpStatusCode(), INVALID_FCM_API_KEY_MSG);
		return ResponseEntity.status(exception.getHttpStatusCode()).body(httpErrorDto);
	}

	@ExceptionHandler(FcmException.class)
	public ResponseEntity<HttpErrorDto> onFcmException(FcmException exception) {
		log.error(exception.getReasonPhrase());
		HttpErrorDto httpErrorDto = new HttpErrorDto(exception.getHttpStatusCode(), exception.getReasonPhrase());
		return ResponseEntity.status(exception.getHttpStatusCode()).body(httpErrorDto);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers,
		HttpStatus status, WebRequest request) {
		Set<FieldDto> fields = exception.getBindingResult().getFieldErrors().stream()
			.map(fieldError -> new FieldDto(fieldError.getField(), fieldError.getDefaultMessage()))
			.collect(Collectors.toSet());
		log.error("Bad request: {}", fields);
		return ResponseEntity.badRequest().body(new BadRequestErrorDto(fields));
	}
}
