package com.notification.notificationcreatorservice.controllers;

import com.notification.notificationcreatorservice.dto.NotificationDto;
import com.notification.notificationcreatorservice.dto.SentNotificationDto;
import com.notification.notificationcreatorservice.entity.Notification;
import com.notification.notificationcreatorservice.mapper.NotificationMapper;
import com.notification.notificationcreatorservice.service.NotificationService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * REST controller for {@link Notification} entity.
 */
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("api/notification")
@OpenAPIDefinition(info = @Info(title = "Notification API"))
public class NotificationController {
    private final NotificationService notificationService;
    private final NotificationMapper notificationMapper;

    /**
     * Method for creating notification.
     *
     * @param notificationDto as {@link NotificationDto}
     * @return response entity with body that contains created notification.
     */
    @PostMapping
    @Operation(
            summary = "Creating notification",
            description = "Method to create notification",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Return created notification.",
                            content = @Content(mediaType = "application/json")
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad request.",
                            content = @Content(mediaType = "application/json")
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "An error occurred on the server.",
                            content = @Content(mediaType = "application/json")
                    )
            }
    )
    public ResponseEntity<NotificationDto> create(@Valid @RequestBody NotificationDto notificationDto) {
        notificationService.create(notificationDto);
        return ResponseEntity.ok(notificationDto);
    }

    /**
     * Method for getting sent notifications by phone number.
     *
     * @param phoneNumber of recipient
     * @return sent notifications by phone number.
     */
    @GetMapping("sent")
    @Operation(
            summary = "Getting sent notifications",
            description = "Method to get page of sent notifications",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Return created notification.",
                            content = @Content(mediaType = "application/json")
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad request.",
                            content = @Content(mediaType = "application/json")
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "An error occurred on the server.",
                            content = @Content(mediaType = "application/json")
                    )
            }
    )
    public ResponseEntity<List<SentNotificationDto>> getSentNotifications(@RequestParam String phoneNumber) {
        return ResponseEntity.ok(notificationService.getSent(phoneNumber).stream()
                .map(notificationMapper::toDto).collect(Collectors.toList()));
    }
}
