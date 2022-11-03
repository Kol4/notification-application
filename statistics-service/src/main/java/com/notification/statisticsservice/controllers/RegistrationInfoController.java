package com.notification.statisticsservice.controllers;

import com.notification.statisticsservice.clients.RegistrationClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class RegistrationInfoController {
    private final RegistrationClient registrationClient;

    @GetMapping("/registration-statistic")
    public String registrationStatistic(Model model) {
        model.addAttribute("statisticInfo", registrationClient.getStatistic());
        return "registrationStatistic";
    }
}
