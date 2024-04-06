package com.project.eTicaret;

import com.project.eTicaret.entity.Customer;
import com.project.eTicaret.repository.FileOperation;
import com.project.eTicaret.service.CustomerManager;
import com.project.eTicaret.service.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;


public class ETradeApplication {

	public static void main(String[] args) {
//		SpringApplication.run(ETradeApplication.class, args);
		Customer customer = new Customer(
				1,"Emil","emil@gmail.com","emil1234"
		);

		Scanner scanner = new Scanner(System.in);
		System.out.println("ID-nizi daxil edin=>");
		int id = scanner.nextInt();

		Scanner sc = new Scanner(System.in);
		System.out.println("Emailinizi daxil edin=>");
		String email = sc.nextLine();

		Scanner sc2 = new Scanner(System.in);
		System.out.println("Adinizi daxil edin=>");
		String firstName = sc2.nextLine();

		Scanner sc3 = new Scanner(System.in);
		System.out.println("Parolunuzu daxil edin=>");
		String password = sc3.nextLine();
		Customer customer2 = new Customer(
				id,firstName,email,password
		);

		CustomerService customerService = new CustomerManager(new FileOperation());

		Scanner sc4 = new Scanner(System.in);
		System.out.println("1)Qeydiyyatdan kecin\n2)Sistemə daxil olun\n3)Çıxış");
		int op = sc4.nextInt();
		switch (op) {
			case 1:customerService.register(customer);
				break;
			case 2:customerService.login(customer);
				break;
			case 3:customerService.signOut();
			default:
				System.out.println("Seciminiz yanlisdir");
		}
	}

}
