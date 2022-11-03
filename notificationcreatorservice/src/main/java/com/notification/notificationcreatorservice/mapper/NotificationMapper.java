package com.notification.notificationcreatorservice.mapper;

import com.notification.notificationcreatorservice.dto.SentNotificationDto;
import com.notification.notificationcreatorservice.entity.Notification;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

/**
 * Notification mapper.
 */
@Component
@AllArgsConstructor
public class NotificationMapper {
    private final ModelMapper modelMapper;

    /**
     * Converts Notification entity to dto.
     *
     * @param notification notification entity
     * @return SentNotificationsDto
     */
    public SentNotificationDto toDto(final Notification notification) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(notification, SentNotificationDto.class);
    }
}
