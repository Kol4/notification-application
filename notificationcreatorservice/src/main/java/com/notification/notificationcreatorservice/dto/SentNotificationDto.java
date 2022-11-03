package com.notification.notificationcreatorservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Response dto for sent notification.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SentNotificationDto {
    private String title;
    private String text;
}
