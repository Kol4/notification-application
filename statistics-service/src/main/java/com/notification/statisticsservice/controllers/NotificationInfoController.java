package com.notification.statisticsservice.controllers;

import com.notification.statisticsservice.clients.NotificationClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class NotificationInfoController {

    private final NotificationClient notificationClient;

    @GetMapping("/notification-statistic")
    public String notificationStatistic() {
        return "notificationStatistic";
    }

    @GetMapping("/notification-statistics")
    public String notificationStatisticsForNumber(Model model, @RequestParam(name = "phoneNumber") String phoneNumber) {
        model.addAttribute("statisticInfo", notificationClient.getStatistic(phoneNumber));
        return "notificationStatistic";
    }

}
