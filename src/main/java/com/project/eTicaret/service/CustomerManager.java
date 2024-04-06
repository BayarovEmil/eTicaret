package com.project.eTicaret.service;

import com.project.eTicaret.entity.Customer;
import com.project.eTicaret.repository.FileRepository;

public class CustomerManager extends CustomerService {
//    private final CustomerRepository customerRepository;

//    public CustomerManager(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }
    private final FileRepository repository;

    public CustomerManager(FileRepository repository) {
        this.repository = repository;
    }

    @Override
    public void successMessage() {
        System.out.println("Sisteme ugurla daxil oldunuz");
    }

    @Override
    public boolean isEmailValid(String email) {
        if (email.contains("@gmail.com")) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean isPasswordValid(String password) {
        if (password.length() >= 4) {
            return true;
        } else {
            System.out.println("parolun uzunlugu 4-den kicik ola bilmez");
            return false;
        }
    }

    @Override
    public boolean isPasswordCorrect(Customer customer) {
        String password = repository.findByEmail(customer.getEmail());
        if (password.equals(customer.getPassword())) {
            return true;
        } else {
            return false;
        }
    }
}
