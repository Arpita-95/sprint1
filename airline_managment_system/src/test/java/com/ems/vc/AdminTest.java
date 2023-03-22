package com.ems.vc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.ems.vc.config.HibernateUtil;
import com.ems.vc.entity.Admin;
import com.ems.vc.model.AdminDTO;
import com.ems.vc.service.AdminService;
import com.ems.vc.serviceImpl.AdminServiceImpl;

public class AdminTest {
	AdminService adminService=new AdminServiceImpl();
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

	//testing for admin registration
	@Test
	@Order(1)
	void testRegisterAdmin()
	{
		Transaction tx=session.beginTransaction();
		Admin admin=Admin.builder().aName("Arpita").email("arpita333@gmail.com").UserName("arp123").password("arp@123").role("admin").build();
		Integer i=(Integer)session.save(admin);
		tx.commit();
		assertThat(i>0).isTrue();
	}

	//testing for get Admin
	@Test
	@Order(2)
	void testGetAdminById()
	{
		AdminDTO adto=adminService.getAdminById(5);
		assertThat(adto.getAName()).isEqualTo("Arpita");
	}

	//this method is use for update Admin
	@Test
	@Order(3)
	void testUpdateAdminById()
	{
		Transaction tx=session.beginTransaction();
		Admin ad=new Admin();
		ad.setAName("Arpita pal");
		AdminDTO adto=adminService.updateAdmin(5, ad);
		tx.commit();
		assertThat(adto.getAName()).isEqualTo("Arpita pal");
	}
	//testing for delete admin
	@Test
	@Order(4)
	@DisplayName(value="Negetive Test Case")
	void testDeleteAdmin()
	{
		adminService.deleteAdmin(16);
		assertThrows(HibernateException.class,()->adminService.getAdminById(16));
	}

}
