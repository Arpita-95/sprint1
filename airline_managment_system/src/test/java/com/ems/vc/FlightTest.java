package com.ems.vc;

import static org.assertj.core.api.Assertions.assertThat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.ems.vc.config.HibernateUtil;
import com.ems.vc.entity.Admin;
import com.ems.vc.entity.Airline;
import com.ems.vc.entity.Flight;
import com.ems.vc.model.AdminDTO;
import com.ems.vc.model.FlightDTO;
import com.ems.vc.service.FlightService;
import com.ems.vc.serviceImpl.FlightServiceImpl;

public class FlightTest {

	FlightService flightService = new FlightServiceImpl();
	
	public static SessionFactory sessionFactory;
	private Session session;
	@BeforeAll
	static void setUp()
	{
		sessionFactory=HibernateUtil.getSessionFactory();
	}
	@BeforeEach
	void openSession()
	{
		session= sessionFactory.openSession();
	}
	@AfterEach
	void closeSession()
	{
		if(session!=null)
			session.close();
		System.out.println("session closed");
	}
	@AfterAll
	static void tearDown()
	{
		if(sessionFactory!=null)
			sessionFactory.close();
		System.out.println("Session factory closed");
	}
	
	@Test
	@Order(1)
	public void testSaveFlight() {
		Transaction tx=session.beginTransaction();
		Flight flight = Flight.builder().flight_id(100).avilableSeats(300).airline(new Airline()).destination("Singapore").build();
		Integer i=(Integer)session.save(flight);
		tx.commit();
		assertThat(i>0).isTrue();
	}
	
	@Test
	@Order(2)
	public void updateFlight() {
		Transaction tx=session.beginTransaction();
		Flight fl=new Flight();
		fl.setDestination("Delhi");
		FlightDTO adto=flightService.updateFlight(1, fl);
		tx.commit();
		assertThat(adto.getDestination()).isEqualTo("Delhi");
	}
	
	@Test
	@Order(3)
	public void testGetFlight() {
		Transaction tx=session.beginTransaction();
		FlightDTO fdto = flightService.getFlight(1);
		assertThat(fdto.getDestination()).isEqualTo("Delhi");
	}
	
	@Test
	@Order(4)
	public void testDeleteFlight() {
		Transaction tx=session.beginTransaction();
	     flightService.deleteFlight(1);
		
	}
}
