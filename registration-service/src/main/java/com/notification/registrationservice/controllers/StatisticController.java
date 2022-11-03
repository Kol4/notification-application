package com.notification.registrationservice.controllers;

import com.notification.registrationservice.dto.StatisticInfoDto;
import com.notification.registrationservice.service.StatisticInfoService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for {@link StatisticInfoDto} entity.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/statistic")
@OpenAPIDefinition(info = @Info(title = "Statistic API"))
public class StatisticController {
    private final StatisticInfoService statisticInfoService;

    /**
     * Method for getting a statistic info {@link StatisticInfoDto}.
     *
     * @return {@link StatisticInfoDto}
     */
    @GetMapping
    @Operation(
        summary = "Getting all statistic info",
        description = "Method to get statistic info",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Return all statistic info.",
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
    public List<StatisticInfoDto> getStatisticInfo() {
        List<StatisticInfoDto> statisticInfos = statisticInfoService.collectStatisticInfo();
        return statisticInfos;
    }
}
