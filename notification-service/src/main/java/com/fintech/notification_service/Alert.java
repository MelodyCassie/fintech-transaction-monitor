package com.fintech.notification_service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alert {
    private String alertType;
    private Double amount;
    private String fromAccount;
    private String toAccount;
    private String transactionId;
    private String riskLevel;
    private String message;
    private LocalDateTime timestamp;

    public Alert(String alertType, Double amount, String fromAccount, String toAccount, String riskLevel) {
        this.alertType = alertType;
        this.amount = amount;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.riskLevel = riskLevel;
        this.timestamp = LocalDateTime.now();
        this.message = generateAlertMessage();
    }

    private String generateAlertMessage() {
        switch(alertType) {
            case "SUSPICIOUS_TRANSACTION":
                return String.format("Suspicious transaction detected: $%.2f from %s to %s", amount, fromAccount, toAccount);
            case "LARGE_DEPOSIT":
                return String.format("Large deposit alert: $%.2f to account %s", amount, toAccount);
            case "FRAUD_ATTEMPT":
                return String.format("Potential fraud attempt: $%.2f from %s", amount, fromAccount);
            default:
                return String.format("Financial alert: $%.2f transaction", amount);
        }
    }
}
