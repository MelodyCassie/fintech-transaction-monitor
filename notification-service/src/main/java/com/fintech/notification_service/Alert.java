package com.fintech.notification_service;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Alert {
    private String message;
    private String transactionId;
    private LocalDateTime timestamp;

    public Alert(String message, String transactionId) {
        this.message = message;
        this.transactionId = transactionId;
        this.timestamp = LocalDateTime.now();
    }

}
