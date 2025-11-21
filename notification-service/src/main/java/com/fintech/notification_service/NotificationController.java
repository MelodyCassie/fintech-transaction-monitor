package com.fintech.notification_service;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/alerts")
public class NotificationController{

    @PostMapping
    public Mono<Alert> createAlert(@RequestBody Alert alert) {
        System.out.println("🚨 ALERT: " + alert.getMessage());
        return Mono.just(alert);
    }

}
