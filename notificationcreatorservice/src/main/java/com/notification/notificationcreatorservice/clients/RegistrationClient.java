package com.notification.notificationcreatorservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Client for registration service.
 */
@FeignClient(name = "registration-service")
public interface RegistrationClient {

    /**
     * Gets Firebase tokens by phone numbers.
     *
     * @param phoneNumbers phone numbers
     * @return map of Firebase tokens
     */
    @GetMapping("info/creator")
    ResponseEntity<Map<String, List<String>>> getFirebaseTokens(@RequestParam Set<String> phoneNumbers);
}
