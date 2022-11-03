package com.notification.notificationcreatorservice.service.impl;

import com.notification.notificationcreatorservice.clients.NotificationSenderClient;
import com.notification.notificationcreatorservice.clients.RegistrationClient;
import com.notification.notificationcreatorservice.dto.NotificationDto;
import com.notification.notificationcreatorservice.dto.SendNotificationRequestDto;
import com.notification.notificationcreatorservice.entity.Notification;
import com.notification.notificationcreatorservice.repository.NotificationRepository;
import com.notification.notificationcreatorservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Implementation of {@link NotificationService}.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;
    private final NotificationSenderClient notificationSenderClient;
    private final RegistrationClient registrationClient;

    @Override
    public Notification create(NotificationDto notificationDto) {
        log.info("Create notification with title '{}'", notificationDto.getTitle());
        Notification notification = new Notification(notificationDto);
        return notificationRepository.save(notification);
    }

    @Async
    @Override
    @Transactional
    public void sendNotificationRequest() {
        log.info("Send request for sending notifications.");
        List<Notification> notifications = notificationRepository.findAllUnsent(System.currentTimeMillis());
        notifications.forEach(this::processNotificationRequest);
    }

    private void processNotificationRequest(Notification notification) {
        Set<String> phoneNumbers = new HashSet<>();
        notification.getRecipients().forEach(r -> phoneNumbers.add(r.getPhoneNumber()));
        Set<String> firebaseTokens = Objects.requireNonNull(registrationClient.getFirebaseTokens(phoneNumbers)
                .getBody()).values().stream().flatMap(List::stream).collect(Collectors.toSet());
        sendNotificationRequest(notification, firebaseTokens);
    }

    private void sendNotificationRequest(
            Notification notification, Set<String> firebaseTokens) {
        if (!firebaseTokens.isEmpty()) {
            notificationSenderClient.sendNotificationRequest(new SendNotificationRequestDto(notification, firebaseTokens));
            updateNotification(notification);
        }
    }

    private void updateNotification(Notification notification) {
        notification.setWasSent(true);
        notificationRepository.save(notification);
    }

    @Override
    public List<Notification> getSent(String phoneNumber) {
        log.info("Getting sent notifications by phone number: {}.", phoneNumber);
        return notificationRepository.findAllSentByPhoneNumber(phoneNumber.replaceAll(" ", "+"));
    }
}
