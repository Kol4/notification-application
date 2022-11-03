package com.notification.registrationservice.service;

import com.notification.registrationservice.entity.UserForRegistration;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UserService {

    /**
     * Saves {@link UserForRegistration}.
     *
     * @param user to save
     * @return saved user
     */
    UserForRegistration save(UserForRegistration user);

    /**
     * Deletes existing {@link UserForRegistration}.
     *
     * @param firebaseToken user firebase token
     */
    void deleteByFirebaseToken(String firebaseToken);

    Map<String, List<String>> getFirebaseTokenByNumber(Set<String> phoneNumbers);
}
