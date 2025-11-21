package com.fintech.transaction_service;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface TransactionRepository extends ReactiveCrudRepository<Transaction, Long> {
Flux<Transaction> findByAmountGreaterThan(Double amount);


}
