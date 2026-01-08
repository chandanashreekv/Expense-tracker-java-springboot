package com.expense.service;



import com.expense.model.ExpenseTransaction;
import com.expense.model.ExpenseUser;
import com.expense.repository.ExpenseTransactionRepository;
import com.expense.repository.ExpenseUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseImpl implements ExpenseTransactionService {

    @Autowired
    private ExpenseTransactionRepository transactionRepository;

    @Autowired
    private ExpenseUserRepository userRepository;

    @Override
    public ExpenseTransaction addTransaction(ExpenseTransaction transaction, String username) {
        // Fetch user using username
        ExpenseUser user = userRepository.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found with username: " + username);
        }

        // Associate user with transaction
        transaction.setUser(user);
        return transactionRepository.save(transaction);
    }

    @Override
    public List<ExpenseTransaction> getAllTransactions(String username) {
        return transactionRepository.findByUserUsername(username);
    }

    @Override
    public void deleteTransaction(Long id, String username) {
        ExpenseTransaction transaction = transactionRepository.findByIdAndUserUsername(id, username);
        if (transaction != null) {
            transactionRepository.delete(transaction);
        } else {
            throw new RuntimeException("Transaction not found or does not belong to the user: " + username);
        }
    }
}