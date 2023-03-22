package com.ems.vc.service;

import javax.persistence.PersistenceException;

import com.ems.vc.entity.Admin;
import com.ems.vc.model.AdminDTO;

public interface AdminService {
      void registerAdmin(Admin admin);
      boolean loginAdmin(String userName,String password);
	AdminDTO getAdminById(int id);
	AdminDTO updateAdmin(int id, Admin admin);
	void deleteAdmin(int id)throws PersistenceException;;
}
