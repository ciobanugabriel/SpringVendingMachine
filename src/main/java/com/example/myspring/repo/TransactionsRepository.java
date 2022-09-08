package com.example.myspring.repo;

import com.example.myspring.entities.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepository extends JpaRepository<Transactions,Long> {
}
