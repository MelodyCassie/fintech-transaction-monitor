package com.fintech.notification_service;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Alert {
    private String message;
    private String transactionId;
    private LocalDateTime timeStamp;

}
