package com.notification.notificationsenderservice.service;

import com.notification.notificationsenderservice.dto.NotificationDto;

import de.bytefish.fcmjava.responses.FcmMessageResponse;

/**
 * Service for sending notification to Firebase Cloud Messaging.
 */
public interface NotificationSenderService {

	/**
	 * Send notification to Firebase Cloud Messaging
	 *
	 * @param notification - notification for send
	 */
	FcmMessageResponse sendNotificationToFCM(NotificationDto notification);
}
