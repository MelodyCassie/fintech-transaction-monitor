package com.fintech.notification_service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class NotificationService {

    public Mono<Alert> processFinancialAlert(Alert alert) {
        return Mono.just(alert);
    }
}
