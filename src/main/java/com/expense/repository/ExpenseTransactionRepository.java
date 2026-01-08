package com.expense.repository;



import com.expense.model.ExpenseTransaction;
import com.expense.model.ExpenseUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseTransactionRepository extends JpaRepository<ExpenseTransaction, Long> {
    List<ExpenseTransaction> findByUserUsername(String username);
    ExpenseTransaction findByIdAndUserUsername(Long id, String username);
}