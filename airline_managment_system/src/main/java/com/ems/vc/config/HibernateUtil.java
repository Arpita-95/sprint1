package com.ems.vc.config;

import java.util.Properties;



import javax.imageio.spi.ServiceRegistry;

import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.ems.vc.entity.Admin;
import com.ems.vc.entity.Passenger;
import com.ems.vc.entity.User;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	
private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory()
	{
		if(sessionFactory==null) {
			try{
				Configuration configuration=new Configuration();
				Properties settings=new Properties();
				settings.put(Environment.DRIVER,"com.mysql.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/airline_vc");
				settings.put(Environment.USER,"root");
				settings.put(Environment.PASS,"Root");
				settings.put(Environment.DIALECT,"org.hibernate.dialect.MySQL8Dialect");
				settings.put(Environment.SHOW_SQL,"true");
				settings.put(Environment.HBM2DDL_AUTO, "create");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");
				configuration.setProperties(settings);
				
				configuration.addAnnotatedClass(User.class);
				configuration.addAnnotatedClass(Admin.class);
				configuration.addAnnotatedClass(Passenger.class);
				
		ServiceRegistry serviceRegistry=(ServiceRegistry) new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		System.out.println("hibernate java config serviceRegistry created");
		sessionFactory=configuration.buildSessionFactory();
		return sessionFactory;
			} catch(HibernateException e)
			{
				System.out.println(e.getMessage());
				
			}
			
		}
		return sessionFactory;
	}
	public static Session getSession()
	{
		return getSessionFactory().openSession();
	}


}
