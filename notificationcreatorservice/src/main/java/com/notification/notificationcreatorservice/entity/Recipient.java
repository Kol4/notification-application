package com.notification.notificationcreatorservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entity class for notification recipient.
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Recipient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phoneNumber;
    @ManyToOne
    private Notification notification;

    /**
     * Constructor which assumes phone number as parameter.
     *
     * @param phoneNumber recipient's phone number
     */
    public Recipient(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @JsonBackReference
    public Notification getNotification() {
        return notification;
    }
}
