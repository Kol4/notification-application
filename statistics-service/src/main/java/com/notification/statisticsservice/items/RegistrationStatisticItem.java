package com.notification.statisticsservice.items;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Class for build statistic info.
 */
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class RegistrationStatisticItem {
    private double version;
    private long numberOfTokens;
    private long numberOfUniquePhoneNumbers;
}
