package com.fintech.transaction_service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping
    public Flux<Transaction> getAllTransactions() {
        log.info("GET /transactions called");
        return transactionRepository.findAll()

                .switchIfEmpty(Flux.just(
                        new Transaction(1000.0, "Default", "User", "Sample transaction")
                ));

    }

    @GetMapping("/test")
    public Mono<String> testEndpoint() {
        log.info("TEST endpoint called");
        return Mono.just("Transaction service is working!");
    }

    @PostMapping
    public Mono<Transaction> createTransaction(@RequestBody Transaction transaction) {
        log.info("POST /transactions called with: {}", transaction);
        return transactionRepository.save(transaction);
    }

    @GetMapping("/large")
    public Flux<Transaction> getLargeTransactions() {
        log.info("GET /transactions/large called");
        return transactionRepository.findByAmountGreaterThan(5000.0)
                .switchIfEmpty(Flux.just(
                        new Transaction(6000.0, "Large", "Transfer", "Sample large transaction")
                ));

    }


}
