package com.fintech.transaction_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping
    public Flux<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @PostMapping
    public Mono<Transaction> createTransaction(@RequestBody Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @GetMapping("/large")
    public Flux<Transaction> getLargeTransactions() {
        return transactionRepository.findByAmountGreaterThan(5000.0);
    }
}
