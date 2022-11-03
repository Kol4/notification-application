package com.notification.notificationcreatorservice.service;

import com.notification.notificationcreatorservice.dto.NotificationDto;
import com.notification.notificationcreatorservice.entity.Notification;

import java.util.List;

/**
 * Service for managing notifications.
 */
public interface NotificationService {
    /**
     * Creates {@link Notification}.
     *
     * @param notificationDto notification to save
     * @return created notification
     */
    Notification create(NotificationDto notificationDto);

    /**
     * Sends request to notification-sender-service for sending notifications.
     */
    void sendNotificationRequest();

    /**
     * Gets sent notifications.
     *
     * @param phoneNumber recipient's phone number
     * @return list of sent notifications
     */
    List<Notification> getSent(String phoneNumber);
}
