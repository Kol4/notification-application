package com.notification.notificationsenderservice.service.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.notification.notificationsenderservice.dto.NotificationDto;
import com.notification.notificationsenderservice.service.NotificationSenderService;

import de.bytefish.fcmjava.client.FcmClient;
import de.bytefish.fcmjava.model.options.FcmMessageOptions;
import de.bytefish.fcmjava.requests.notification.NotificationMulticastMessage;
import de.bytefish.fcmjava.requests.notification.NotificationPayload;
import de.bytefish.fcmjava.responses.FcmMessageResponse;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NotificationSenderServiceImpl implements NotificationSenderService {

	private final FcmClient fcmClient;

	public NotificationSenderServiceImpl() {
		this.fcmClient = new FcmClient();
	}

	@Override
	public FcmMessageResponse sendNotificationToFCM(NotificationDto notification) {
		log.info("Send notification to FCM");
		log.debug("Notification: title = {}, body = {}", notification.getTitle(), notification.getBody());
		FcmMessageOptions fcmMessageOptions = FcmMessageOptions.builder().build();
		NotificationPayload notificationPayload = NotificationPayload.builder()
			.setTitle(notification.getTitle())
			.setBody(notification.getBody())
			.build();
		NotificationMulticastMessage notificationMulticastMessage = new NotificationMulticastMessage(fcmMessageOptions,
			new ArrayList<>(notification.getFirebaseTokens()), notificationPayload);
		return fcmClient.send(notificationMulticastMessage);
	}
}
