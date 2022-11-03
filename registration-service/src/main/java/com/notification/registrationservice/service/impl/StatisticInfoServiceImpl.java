package com.notification.registrationservice.service.impl;

import com.notification.registrationservice.dto.StatisticInfoDto;
import com.notification.registrationservice.repository.UserRepository;
import com.notification.registrationservice.service.StatisticInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class StatisticInfoServiceImpl implements StatisticInfoService {
    private final UserRepository userRepository;

    @Override
    public List<StatisticInfoDto> collectStatisticInfo() {
        log.info("Getting statistic");
        return userRepository.findAllVersionWithCountOfFirebaseTokensAndPhoneNumber();
    }
}
