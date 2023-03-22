package com.ems.vc.dao;

import javax.persistence.PersistenceException;

import com.ems.vc.entity.Admin;

public interface AdminDao {
	void registerAdmin(Admin admin);
	boolean loginAdmin(String userName,String password);
	void deleteAdmin(int id)throws PersistenceException;
	Admin updateAdmin(int id, Admin admin);
	Admin getAdminById(int id);
	

}
