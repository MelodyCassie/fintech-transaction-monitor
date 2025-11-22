package com.fintech.notification_service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class NotificationService {

    public Mono<Alert> processFinancialAlert(Alert alert) {
        return Mono.just(alert);
    }

    public Mono<Alert> detectSuspiciousActivity(Double amount, String fromAccount, String toAccount) {
        String alertType = amount > 10000 ? "SUSPICIOUS_TRANSACTION" : "LARGE_DEPOSIT";
        String riskLevel = amount > 50000 ? "HIGH" : amount > 10000 ? "MEDIUM" : "LOW";

        Alert alert = new Alert(alertType, amount, fromAccount, toAccount, riskLevel);
        return processFinancialAlert(alert);
    }
}
