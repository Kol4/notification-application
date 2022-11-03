package com.notification.statisticsservice.clients;

import com.notification.statisticsservice.items.NotificationStatisticItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "notification-service", url = "localhost:8060")
public interface NotificationClient {

    @GetMapping(value = "/creator/api/notification/sent")
    List<NotificationStatisticItem> getStatistic(@RequestParam("phoneNumber") String phoneNumber);
}
