package com.expense.service;

import com.expense.model.ExpenseUser;
import com.expense.repository.ExpenseUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseUserService {

    @Autowired
    ExpenseUserRepository userRepo;

    public ExpenseUser registerUser(ExpenseUser user) {
        if (userRepo.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        if (userRepo.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        return userRepo.save(user);
    }

    public ExpenseUser login(String username, String password) {
        ExpenseUser user = userRepo.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        throw new RuntimeException("Invalid username or password");
    }

}