package com.project.eTicaret.repository;

import com.project.eTicaret.entity.Customer;

public interface FileRepository {
    void add(Customer user);
    void findAll();
    boolean isEmailExist(String email);
    String findByEmail(String email);
}
