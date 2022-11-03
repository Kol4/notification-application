package com.notification.notificationcreatorservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.notification.notificationcreatorservice.entity.Notification;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

/**
 * Dto for sending notification request.
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class SendNotificationRequestDto {
    private Set<String> firebaseTokens;
    private String title;
    private String body;

    /**
     * Assumes {@link Notification} and set of FireBase tokens.
     *
     * @param notification notification entity
     * @param firebaseTokens set of FireBase tokens
     */
    public SendNotificationRequestDto(Notification notification, Set<String> firebaseTokens) {
        this.firebaseTokens = firebaseTokens;
        this.title = notification.getTitle();
        this.body = notification.getText();
    }
}
