package com.melvin.tonia.hibernate.oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LaunchOnetoMany {

	public static void main(String[] args) {
	
		Country country = new Country();
		State state = new State();
		State state2 = new State();
		state.setStateName("Kerala");
		state2.setStateName("TamilNadu");
		
		country.setCountryName("India");
		state.setStateName("Kerala");
		country.getState().add(state);
		country.getState().add(state2);
		state.setCountry(country);
		state2.setCountry(country);
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(country);
		session.save(state);
		session.save(state2);
		
		session.getTransaction().commit();
		session.close();
		
		
	}

}
