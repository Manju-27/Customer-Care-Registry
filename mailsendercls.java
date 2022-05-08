package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class mailsendercls {
	 @Autowired
	 private JavaMailSender mailsender;
	 
	 public void sender(String tomail, String body,String subject) {
		 SimpleMailMessage mes=new SimpleMailMessage();
		 mes.setFrom("manju@gmail.com");
		 mes.setTo(tomail);
		 mes.setText(body);
		 mes.setSubject(subject);
		 
		 mailsender.send(mes);
		 System.out.println("mail sended");
	 }


}