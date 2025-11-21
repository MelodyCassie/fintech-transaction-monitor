package com.fintech.notification_service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/alerts")
public class NotificationController{

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public Mono<Alert> createAlert(@RequestBody Alert alert) {
        log.info("Received alert request: {}", alert.getMessage());
        return notificationService.sendAlert(alert);
    }


}
