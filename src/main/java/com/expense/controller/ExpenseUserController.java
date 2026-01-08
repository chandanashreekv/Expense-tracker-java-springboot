package com.expense.controller;


import com.expense.model.ExpenseUser;
import com.expense.service.ExpenseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ExpTrack")
@CrossOrigin
public class ExpenseUserController {

    @Autowired
    ExpenseUserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody ExpenseUser user) {
        try {
            ExpenseUser savedUser = userService.registerUser(user);
            return ResponseEntity.ok(savedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ExpenseUser login(@RequestBody ExpenseUser user) {
        return userService.login(user.getUsername(), user.getPassword());
    }

}