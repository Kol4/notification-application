package com.notification.registrationservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * Class for build statistic info.
 */
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class StatisticInfoDto {
    @Schema(description = "Version of mobile application", example = "1.1")
    @NotNull
    @Positive
    private Double version;
    @Schema(description = "count firebase tokens's for version", example = "+74951270777")
    @Positive
    private Long numberOfTokens;
    @Schema(description = "Count of phone number's for version", example = "270777")
    @Positive
    private Long numberOfUniquePhoneNumbers;
}
