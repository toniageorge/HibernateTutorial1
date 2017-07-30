package com.melvin.tonia.hibernate.collections;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CollectionLauncher {
	public static void main(String[] args) {
		
		AddressDetails homeAddress = new AddressDetails();
		homeAddress.setCity(" home City Name");
		homeAddress.setState(" home State Name");
		homeAddress.setPincode("123ED");
		
		AddressDetails officeAddress = new AddressDetails();
		officeAddress.setCity(" office City Name");
		officeAddress.setState(" office State Name");
		officeAddress.setPincode("office123");
		
		
		Person person = new Person();
		person.setPersonName("Tonia");
		person.getListOfAddress().add(homeAddress);
		person.getListOfAddress().add(officeAddress);
		
	
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(person);
		session.getTransaction().commit();
		session.close();
		
		
	}
}
