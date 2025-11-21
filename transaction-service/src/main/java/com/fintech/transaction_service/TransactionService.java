package com.fintech.transaction_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Flux<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }
    public Mono<Transaction> createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Flux<Transaction> getLargeTransactions() {
        return transactionRepository.findByAmountGreaterThan(5000.0);
    }
}
