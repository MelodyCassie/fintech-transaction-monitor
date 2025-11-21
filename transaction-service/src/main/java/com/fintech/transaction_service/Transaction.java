package com.fintech.transaction_service;

import com.fasterxml.jackson.databind.node.DoubleNode;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

public class Transaction {
    private Long id;
    private Double amount;
    private String fromAccount;
    private String toAccount;
    private String description;
    private LocalDateTime timestamp;

}
