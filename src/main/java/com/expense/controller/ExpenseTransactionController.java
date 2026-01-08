package com.expense.controller;

import com.expense.model.ExpenseTransaction;
import com.expense.service.ExpenseTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ExpTrack/transactions")
@CrossOrigin
public class ExpenseTransactionController {

    @Autowired
    private ExpenseTransactionService transactionService;

    // Add transaction for given username
    @PostMapping("/{username}")
    public ExpenseTransaction addTransaction(@RequestBody ExpenseTransaction transaction, @PathVariable String username) {
        return transactionService.addTransaction(transaction, username);
    }

    // Get all transactions for given username
    @GetMapping("/{username}")
    public List<ExpenseTransaction> getAllTransactions(@PathVariable String username) {
        return transactionService.getAllTransactions(username);
    }

    // Delete specific transaction by id and username
    @DeleteMapping("/{username}/{id}")
    public void deleteTransaction(@PathVariable String username, @PathVariable Long id) {
        transactionService.deleteTransaction(id, username);
    }
}
