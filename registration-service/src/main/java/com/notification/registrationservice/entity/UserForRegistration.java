package com.notification.registrationservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * Entity class for user to be registered.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "userforregistration")
public class UserForRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String firebaseToken;
    @NotNull
    @Positive
    private Double applicationVersion;

    /**
     * Constructor which assumes phone number, firebase token and application version.
     *
     * @param phoneNumber        user's phone number
     * @param firebaseToken      user's firebase token
     * @param applicationVersion version of user's mobile application
     */
    public UserForRegistration(String phoneNumber, String firebaseToken, Double applicationVersion) {
        this.phoneNumber = phoneNumber;
        this.firebaseToken = firebaseToken;
        this.applicationVersion = applicationVersion;
    }
}
