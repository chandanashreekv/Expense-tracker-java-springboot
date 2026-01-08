package com.expense.repository;

import com.expense.model.ExpenseTransaction;
import com.expense.model.ExpenseUser;

//import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseUserRepository extends JpaRepository<ExpenseUser, Long> {

    boolean existsByEmail(String email);
    boolean existsByUsername(String username);

    ExpenseUser findByUsername(String username);
}