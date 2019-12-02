package com.example.demo.controller;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
//import com.example.demo.repository.UserRepository;
import com.example.demo.service.NotificationService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController 
{
	private Logger logger = LoggerFactory.getLogger(RegistrationController.class);
	
	@Autowired
	private NotificationService notificationService;
	
	//@Autowired
	//private UserRepository userRepository;
	
	@Autowired
	private EntityManager entityManager;
	

	@RequestMapping("/send-email")
	public String signupSuccess(@RequestBody User user)
	{
		
		User userobj = new User();
		userobj = entityManager.find(User.class, user.getEmail());
		System.out.println(userobj);	
		
		User user1 = new User();
		user1.setEmail(user.getEmail());
		user1.setPassword(userobj.getPassword());
		
		try
		{
			notificationService.Sendnotification(user1);
		}
		catch(MailException e)
		{
			logger.info("Error sending email" + e.getMessage());
		}
		
		return "Thank you for registering";
	}
}
