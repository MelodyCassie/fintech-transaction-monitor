package com.fintech.notification_service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class NotificationService {

    public Mono<Alert> sendAlert(Alert alert) {

        System.out.println("🔔 SENDING ALERT: " + alert.getMessage());
        return Mono.just(alert);
    }
}
