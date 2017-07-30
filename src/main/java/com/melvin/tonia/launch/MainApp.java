package com.melvin.tonia.launch;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.melvin.tonia.model.Address;
import com.melvin.tonia.model.User;

public class MainApp {

	public static void main(String[] args) {
	
		Address homeAddress = new Address();
		homeAddress.setCity(" home City Name");
		homeAddress.setState(" home State Name");
		homeAddress.setPincode("123ED");
		
		Address officeAddress = new Address();
		officeAddress.setCity(" office City Name");
		officeAddress.setState(" office State Name");
		officeAddress.setPincode("office123");
		
		
		User user = new User();
		user.setUserName("First  User");
		user.setJoinedDate(new Date());
		user.setDescription("Description for fisrt person goes here");
		user.setHomeAddress(homeAddress);
		user.setOfficeAddress(officeAddress);
		
		User user2 = new User();
		user2.setUserName("Second  User");
		user2.setJoinedDate(new Date());
		user2.setDescription("Description for Second person goes here");
		user2.setHomeAddress(homeAddress);
		user2.setOfficeAddress(officeAddress);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(user);
		session.save(user2);
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		User retrivedUser = session.get(User.class, 1);
		session.close();
		System.out.println(retrivedUser.getUserName());
		
		
		
	}

}
