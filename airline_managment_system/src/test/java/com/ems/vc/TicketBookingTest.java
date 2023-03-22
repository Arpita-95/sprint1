package com.ems.vc;

import static org.assertj.core.api.Assertions.assertThat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ems.vc.config.HibernateUtil;
import com.ems.vc.model.TicketBookingDTO;
import com.ems.vc.service.TicketService;
import com.ems.vc.serviceImpl.TicketServiceImpl;

public class TicketBookingTest {
	public static SessionFactory sessionFactory;
	private Session session;
	TicketService tServ=new TicketServiceImpl();

	@BeforeAll
	static void setUp()
	{
		sessionFactory=HibernateUtil.getSessionFactory();
	}
	@BeforeEach
	void openSession()
	{
		session=sessionFactory.openSession();
		
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
		System.out.println("session factory closed");
	}
	
//	@Test
//	void testBookFlight()
//	{
//		Transaction tx=session.beginTransaction();
//		TicketBookingDTO tDto=tServ.bookFlight(1, LocalDate.of(2023, 03, 16), "sri@gmail.com", 3, "Indigo");		
//		tx.commit();
//		assertThat(tDto.getNo_of_passenger()).isEqualTo(3);
//	}
	@Test
	void testGetTicket()
	{
		TicketBookingDTO tD= tServ.getTicket(22769);
		assertThat(tD.getNo_of_passenger()).isEqualTo(0);
	}

}
