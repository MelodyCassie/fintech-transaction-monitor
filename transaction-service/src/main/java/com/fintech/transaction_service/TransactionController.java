package com.fintech.transaction_service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public Flux<Transaction> getAllTransactions() {
        log.info("GET /transactions called");
        return transactionService.getAllTransactions();
    }

    @PostMapping
    public Mono<Transaction> createTransaction(@RequestBody Transaction transaction) {
        log.info("POST /transactions called with: {}", transaction);
        return transactionService.createTransaction(transaction);
    }

    @GetMapping("/large")
    public Flux<Transaction> getLargeTransactions() {
        log.info("GET /transactions/large called");
        return transactionService.getLargeTransactions();
    }

    @GetMapping("/test")
    public Mono<String> testEndpoint() {
        log.info("TEST endpoint called");
        return Mono.just("Transaction service is working!");
    }
}
