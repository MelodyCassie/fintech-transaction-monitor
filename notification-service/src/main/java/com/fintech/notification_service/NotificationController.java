package com.fintech.notification_service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/alerts")
public class NotificationController{

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/suspicious")
    public Mono<Alert> flagSuspiciousTransaction(@RequestParam Double amount,
                                                 @RequestParam String fromAccount,
                                                 @RequestParam String toAccount) {
        return notificationService.detectSuspiciousActivity(amount, fromAccount, toAccount);
    }

    @PostMapping("/custom")
    public Mono<Alert> createCustomAlert(@RequestBody Alert alert) {
        return notificationService.processFinancialAlert(alert);
    }

    @GetMapping("/health")
    public Mono<String> healthCheck() {
        return Mono.just("FinTech Alert Service Operational");
    }

}
