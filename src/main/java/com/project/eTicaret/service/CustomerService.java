package com.project.eTicaret.service;

import com.project.eTicaret.entity.Customer;

public abstract class CustomerService {
    public void login(Customer customer) {
        if (isEmailValid(customer.getEmail())) {
            if (isPasswordValid(customer.getPassword())) {
                if (isPasswordCorrect(customer)) {
                    successMessage();
                }
                else {
                    System.out.println("Parolunuzu dogru daxil edin");
                }
            } else {
                System.out.println("Parol dogru formatda deyil");
            }
        } else {
            System.out.println("Email dogru formatda deyil");
        }
    }
    public void register(Customer customer){
        if (isPasswordValid(customer.getPassword())&& isEmailValid(customer.getEmail())) {
            System.out.println("Istifadeci sisteme daxil oldu");
        } else {
            info();
        }
    }
    public void signOut(){
        System.out.println("Istifadeci sistemi terk eledi");
    }
    public void info(){
        System.out.println("Something went wrong");
    }
    public abstract void successMessage();
    public abstract boolean isEmailValid(String email);
    public abstract boolean isPasswordValid(String password);
    public abstract boolean isPasswordCorrect(Customer customer);
}
