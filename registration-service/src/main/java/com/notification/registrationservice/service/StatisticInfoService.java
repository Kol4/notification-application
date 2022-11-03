package com.notification.registrationservice.service;

import com.notification.registrationservice.dto.StatisticInfoDto;

import java.util.List;

public interface StatisticInfoService {
    /**
     * Get statistic info {@link StatisticInfoDto}.
     *
     * @return {@link StatisticInfoDto}
     */
    List<StatisticInfoDto> collectStatisticInfo();
}
