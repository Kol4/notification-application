package com.notification.notificationsenderservice.dto;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Request dto class for sending to FCM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@Getter
public class NotificationDto {
	@Schema(description = "Firebase tokens", example = "[\"eefgvrZuSCCpRCFerM6Hdw:APA...whFp6f9rqy_tz3q\"]")
	@NotNull(message = "Tokens may not be null")
	@Size(min = 1, message = "Must have at least one token")
	private Set<@NotBlank @Size(max = 163) String> firebaseTokens;
	@Schema(description = "Notification title", example = "Test title")
	@Length(max = 64, message = "Length should be less than 64 symbols")
	@NotBlank(message = "Title may not be null")
	private String title;
	@Schema(description = "Notification body", example = "Test body")
	@Length(max = 256, message = "Length should be less than 256 symbols")
	private String body;
}
