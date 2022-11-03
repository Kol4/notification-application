package com.notification.registrationservice.controllers;

import com.notification.registrationservice.dto.UserDto;
import com.notification.registrationservice.entity.UserForRegistration;
import com.notification.registrationservice.service.UserService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for {@link UserForRegistration} entity.
 */
@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api")
@OpenAPIDefinition(info = @Info(title = "Registration API for mobile applications"))
public class UserController {

    private final UserService userService;

    /**
     * Method for saving a new {@link UserForRegistration}.
     *
     * @param userDto dto of {@link UserForRegistration}
     * @return {@link UserForRegistration} with needed params
     */
    @PostMapping("/registration")
    @Operation(
        summary = "Register a new user",
        description = "Method to register a new user",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Return created user.",
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
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        userService.save(new UserForRegistration(userDto.getPhoneNumber(), userDto.getFirebaseToken(), userDto.getVersion()));
        return ResponseEntity.ok(userDto);
    }

    /**
     * Method to delete {@link UserForRegistration} entity from database by firebase token.
     *
     * @param firebaseToken of the user to be deleted.
     */
    @DeleteMapping("/delete")
    @Operation(
        summary = "Delete user",
        description = "Method to delete user",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "User was deleted."
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
    public ResponseEntity<String> deleteUser(@RequestParam("firebaseToken") String firebaseToken) {
        userService.deleteByFirebaseToken(firebaseToken);
        return ResponseEntity.ok(firebaseToken);
    }
}
