package com.notification.registrationservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.notification.registrationservice.entity.UserForRegistration;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * Request dto class for creating {@link UserForRegistration}.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@Getter
public class UserDto {

    @Schema(description = "Phone number", example = "+74951270777")
    @NotBlank
    private String phoneNumber;
    @Schema(description = "Firebase token")
    @NotBlank
    private String firebaseToken;
    @Schema(description = "Version of mobile application", example = "1.1")
    @NotNull
    @Positive
    private Double version;
}



