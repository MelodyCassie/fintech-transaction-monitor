package com.fintech.notification_service;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/alerts")
public class NotificationController{

    @PostMapping
    public Mono<Alert> createAlert(@RequestBody Alert alert) {
        System.out.println("ALERT: " + alert.getMessage());
        return Mono.just(alert);
    }

    @GetMapping("/test")
    public Mono<String> test() {
        return Mono.just("Notification service is working!");
    }

}
