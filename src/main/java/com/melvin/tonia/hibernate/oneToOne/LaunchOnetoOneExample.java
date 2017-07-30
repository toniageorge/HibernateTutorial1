package com.melvin.tonia.hibernate.oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LaunchOnetoOneExample {

	public static void main(String [] args){
		
		Student st = new Student();
		Vehicle vehicle = new  Vehicle();
		 st.setStudentName("Melvin");
		 vehicle.setVehicleName("OOD");
		 st.setVehicle(vehicle);
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		session.save(st);
		session.save(vehicle);
		
		session.getTransaction().commit();
		session.close();
	}
}
