package com.notification.notificationcreatorservice.repository;

import com.notification.notificationcreatorservice.entity.Notification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for Notification entity.
 */
@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    /**
     * Get unsent notifications.
     *
     * @param currentTime current time in Timestamp
     * @return {@link List<String>}
     */
    @EntityGraph(value = "Notification.detail", type = EntityGraph.EntityGraphType.LOAD)
    @Query("from Notification n where n.dispatchTime <= ?1 and n.wasSent = false")
    List<Notification> findAllUnsent(long currentTime);

    /**
     * Get sent notifications by phone number.
     *
     * @param phoneNumber recipient's phone number
     * @return {@link List<String>}
     */
    @EntityGraph(value = "Notification.detail", type = EntityGraph.EntityGraphType.LOAD)
    @Query("from Notification n left join n.recipients r where n.wasSent = true and r.phoneNumber = ?1")
    List<Notification> findAllSentByPhoneNumber(String phoneNumber);
}
