package com.notification.notificationcreatorservice.dto;

import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import com.notification.notificationcreatorservice.entity.Notification;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.util.Set;

/**
 * Request dto for creating {@link Notification}.
 */
@Getter
public class NotificationDto {
    @NotBlank()
    @Schema(description = "Notification title", example = "Test title")
    @NotBlank(message = "Title may not be null")
    private String title;
    @NotBlank
    @Schema(description = "Notification text", example = "Test text")
    @Length(max = 256, message = "Length should be less than 256 symbols")
    private String text;
    @NotNull
    @Positive(message = "Dispatch time must be positive")
    @Schema(description = "Dispatch time (Timestamp)", example = "1666550231949")
    private Long dispatchTime;
    @NotNull
    @Schema(description = "Recipients' phone numbers")
    private Set<@Pattern(
            regexp = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$",
            message = "Phone number must be valid") String> phoneNumbers;
}
