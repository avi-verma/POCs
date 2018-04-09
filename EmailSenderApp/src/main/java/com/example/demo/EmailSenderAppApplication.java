package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class EmailSenderAppApplication implements CommandLineRunner {
	@Autowired
	MailSenderApi mailSenderApi;
	
	public static void main(String[] args) {
		SpringApplication.run(EmailSenderAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK");
		String from = "avivrma95@gmail.com";
		String to = "avitcs2017@gmail.com";
		String subject = "JavaMailSender";
		String body = "Just-Testing!";
		
		mailSenderApi.sendMail(from, to, subject, body);
		
	}
	
}
