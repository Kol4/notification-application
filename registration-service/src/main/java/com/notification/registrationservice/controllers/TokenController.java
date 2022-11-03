package com.notification.registrationservice.controllers;

import com.notification.registrationservice.service.UserService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/")
@OpenAPIDefinition(info = @Info(title = "Registration API for mobile applications"))
public class TokenController {

    private final UserService userService;

    /**
     * Method to get data for notification sender service
     *
     * @param phoneNumbers user's phone numbers.
     */
    @GetMapping("/info/creator")
    @Operation(
        summary = "Get firebase token",
        description = "Method to get firebase token by phone number",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Return all tokens.",
                content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                responseCode = "400",
                description = "Bad request.",
                content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                responseCode = "500",
                description = "An error occurred on the server.",
                content = @Content(mediaType = "application/json")
            )
        }
    )
    public Map<String, List<String>> getFireBaseTokens(@RequestParam("phoneNumbers") Set<String> phoneNumbers) {
        return userService.getFirebaseTokenByNumber(phoneNumbers);
    }

}
