package com.notification.notificationsenderservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notification.notificationsenderservice.dto.NotificationDto;
import com.notification.notificationsenderservice.service.NotificationSenderService;

import de.bytefish.fcmjava.responses.FcmMessageResponse;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;

/**
 * REST controller for sending notification to Firebase Cloud Messaging.
 */
@RestController
@RequestMapping("api/notification/send")
@RequiredArgsConstructor
@OpenAPIDefinition(info = @Info(title = "Send notification to Firebase Cloud Messaging for internal services"))
public class NotificationSenderController {

	private final NotificationSenderService notificationSenderService;

	/**
	 * Method for sending notification to FCM.
	 *
	 * @param notification dto of {@link NotificationDto}
	 * @return {@link FcmMessageResponse}
	 */
	@PostMapping
	@Operation(
		summary = "Send a notification to FCM by tokens",
		description = "Method to sending a notification to FCM by tokens",
		responses = {
			@ApiResponse(
				responseCode = "200",
				description = "Return created user.",
				content = @Content(mediaType = "application/json")
			),
			@ApiResponse(
				responseCode = "400",
				description = "Bad request.",
				content = @Content(mediaType = "application/json")
			),
			@ApiResponse(
				responseCode = "401",
				description = "Invalid API fcm key.",
				content = @Content(mediaType = "application/json")
			),
			@ApiResponse(
				responseCode = "500",
				description = "An error occurred on the server.",
				content = @Content(mediaType = "application/json")
			)
		}
	)
	public ResponseEntity<FcmMessageResponse> sendNotificationToFCM(@RequestBody @Validated NotificationDto notification) {
		return ResponseEntity.ok(notificationSenderService.sendNotificationToFCM(notification));
	}
}
