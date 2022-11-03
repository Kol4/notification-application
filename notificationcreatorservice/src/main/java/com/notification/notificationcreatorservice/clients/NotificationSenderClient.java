package com.notification.notificationcreatorservice.clients;

import com.notification.notificationcreatorservice.dto.SendNotificationRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Client for notification sender service.
 */
@FeignClient(name = "notification-sender-service")
public interface NotificationSenderClient {

    /**
     * Sends request for sending notification.
     *
     * @param sendNotificationRequestDto as {@link SendNotificationRequestDto}
     * @return response entity
     */
    @PostMapping("notification/send")
    ResponseEntity<String> sendNotificationRequest(@RequestBody SendNotificationRequestDto sendNotificationRequestDto);
}
