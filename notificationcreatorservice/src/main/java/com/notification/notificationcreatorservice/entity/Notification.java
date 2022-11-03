package com.notification.notificationcreatorservice.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.notification.notificationcreatorservice.dto.NotificationDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Notification entity class.
 */
@Entity
@Getter
@Setter
@NamedEntityGraph(name = "Notification.detail", attributeNodes = @NamedAttributeNode("recipients"))
@NoArgsConstructor
public class Notification {
    @Id
    @Nullable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String text;
    private Long dispatchTime;
    private boolean wasSent;
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "notification_id", referencedColumnName = "id")
    private Set<Recipient> recipients;

    /**
     * Constructor which assumes notification dto.
     *
     * @param notificationDto as {@link NotificationDto}
     */
    public Notification(NotificationDto notificationDto) {
        this.title = notificationDto.getTitle();
        this.text = notificationDto.getText();
        this.dispatchTime = notificationDto.getDispatchTime();
        this.recipients = notificationDto.getPhoneNumbers().stream().map(Recipient::new).collect(Collectors.toSet());
    }

    @JsonManagedReference
    public Set<Recipient> getRecipients() {
        return recipients;
    }
}
