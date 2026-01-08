package com.expense.service;



import com.expense.model.ExpenseTransaction;

import java.util.List;

public interface ExpenseTransactionService {
    ExpenseTransaction addTransaction(ExpenseTransaction transaction, String username);
    List<ExpenseTransaction> getAllTransactions(String username);
    void deleteTransaction(Long id, String username);
}