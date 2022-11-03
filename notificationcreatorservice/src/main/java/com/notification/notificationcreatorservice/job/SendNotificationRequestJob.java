package com.notification.notificationcreatorservice.job;

import com.notification.notificationcreatorservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Job for sending notification request.
 */
@Service
@RequiredArgsConstructor
public class SendNotificationRequestJob {
    private final NotificationService notificationService;

    /**
     * Sends notification request every minute.
     */
    @Scheduled(cron = "0 * * * * *")
    public void sendNotificationRequest() {
        notificationService.sendNotificationRequest();
    }
}
