package com.ems.vc.daoimpl;

import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

import org.hibernate.Session;

import com.ems.vc.config.HibernateUtil;
import com.ems.vc.dao.AdminDao;
import com.ems.vc.entity.Admin;

public class AdminDaoImpl implements AdminDao {

	@Override
	public void registerAdmin(Admin admin) {
		Session session=HibernateUtil.getSession();
		session.beginTransaction();
		session.save(admin);
		session.getTransaction().commit();
		
		session.close();
		
	}

	@Override
	public boolean loginAdmin(String userName, String password) {
		Session session=HibernateUtil.getSession();
		Admin admin=(Admin) session.get(Admin.class,1);
		if(admin.getUserName().equals(userName)&& admin.getPassword().equals(password))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void deleteAdmin(int id) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Admin updateAdmin(int id, Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin getAdminById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

    
}
