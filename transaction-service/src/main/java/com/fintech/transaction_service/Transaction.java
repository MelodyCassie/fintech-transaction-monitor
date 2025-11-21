package com.fintech.transaction_service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("transactions")
public class Transaction {
    @Id
    private Long id;
    private Double amount;
    private String fromAccount;
    private String toAccount;
    private String description;
    private LocalDateTime timestamp;

    public Transaction(Double amount, String fromAccount, String toAccount, String description) {
        this.amount = amount;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.description = description;
        this.timestamp = LocalDateTime.now();
    }

}
