package com.notification.registrationservice.service.impl;

import com.notification.registrationservice.entity.UserForRegistration;
import com.notification.registrationservice.repository.UserRepository;
import com.notification.registrationservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Implementation of {@link UserForRegistration}.
 */
@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserForRegistration save(UserForRegistration user) {
        log.info("Saving user");
        return userRepository.save(user);
    }

    @Override
    public void deleteByFirebaseToken(String firebaseToken) {
        log.info("Delete user with token: {}", firebaseToken);
        userRepository.deleteByFirebaseToken(firebaseToken);
    }

    @Override
    public Map<String, List<String>> getFirebaseTokenByNumber(Set<String> phoneNumbers) {
        log.info("Getting firebase tokens by numbers: {}", phoneNumbers);
        return phoneNumbers.stream().collect(Collectors.toMap(
            Function.identity(), userRepository::getFirebaseTokenUsingPhoneNumber));
    }
}
