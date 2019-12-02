package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;

@Service
public class NotificationService 
{
	private JavaMailSender javaMailSender;

	@Autowired
	public NotificationService(JavaMailSender javaMailSender) 
	{
		super();
		this.javaMailSender = javaMailSender;
	}
	
	public void Sendnotification(User user) throws MailException
	{
		SimpleMailMessage mail = new SimpleMailMessage();
		
		mail.setTo(user.getEmail());
		mail.setFrom("projectmng789syst@gmail.com");
		mail.setSubject("Project Assignment");
		mail.setText("Hi USERNAME,\n\nThis is to inform you that you have been relegated to the undertaking PROJECTNAME. \n\nPlease login using the given credentials.\n\nYour login qualifications are as per the following:\nUserId: " + user.getEmail() + "\nPassword: "+ user.getPassword());
		
		javaMailSender.send(mail);
	}
	

	
	
}
