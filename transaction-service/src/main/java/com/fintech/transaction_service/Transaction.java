package com.fintech.transaction_service;

import com.fasterxml.jackson.databind.node.DoubleNode;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Data
@Table("transactions")
public class Transaction {
    private Long id;
    private Double amount;
    private String fromAccount;
    private String toAccount;
    private String description;
    private LocalDateTime timestamp;

}
