package com.notification.statisticsservice.clients;

import com.notification.statisticsservice.items.RegistrationStatisticItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "registration-service", url = "localhost:8060")
public interface RegistrationClient {

    @GetMapping("registration/api/statistic")
    List<RegistrationStatisticItem> getStatistic();
}
