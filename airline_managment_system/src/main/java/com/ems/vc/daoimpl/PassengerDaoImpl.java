package com.ems.vc.daoimpl;

import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;


import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ems.vc.config.HibernateUtil;
import com.ems.vc.dao.PassengerDoa;
import com.ems.vc.entity.Admin;
import com.ems.vc.entity.Passenger;


public class PassengerDaoImpl implements PassengerDoa {

	@Override
	public void savePassenger(Passenger passenger) {
		try(Session session=HibernateUtil.getSession())
		{
			session.beginTransaction();
			session.save(passenger);
			session.getTransaction().commit();
			session.clear();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public boolean login(String userName, String password) {
		Session session=HibernateUtil.getSession();
		Passenger p=(Passenger) session.get(Passenger.class,2);
		if(p.getUserName().equals(userName)&& p.getPassword().equals(password))
		{
			return true;
		}
		else
		return false;
	}

	@Override
	public Passenger getPassenger(int id) {
		try(Session session=HibernateUtil.getSession())
		{
			Passenger passenger=(Passenger)session.get(Passenger.class,id);
			return passenger;
		}catch (HibernateException e)
		{
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Passenger updatePassenger(int id, Passenger passenger) {
		try(Session session=HibernateUtil.getSession())
		{
			Passenger pass=(Passenger)session.load(Passenger.class, id);
			pass.setName(passenger.getName());
			pass.setEmail(passenger.getEmail());
			pass.setPhno(passenger.getPhno());
			pass.setUserName(passenger.getUserName());
			pass.setPassword(passenger.getPassword());
			
			
			session.beginTransaction();
			session.saveOrUpdate(pass);
			session.getTransaction().commit();
			return pass;
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}

	@Override
	public void deletePassenger(int id) throws PersistenceException {
		try(Session session=HibernateUtil.getSession())
		{
			Passenger passn=session.load(Passenger.class,id);
			session.beginTransaction();
			session.delete(passn);
			session.getTransaction().commit();
		}catch(HibernateException e)
		{
			System.out.println(e);
		}
		
	}

	@Override
	public Passenger getPassengerByEmail(String pEmail) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
