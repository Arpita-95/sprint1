package com.ems.vc.dao;

import javax.persistence.PersistenceException;

import com.ems.vc.entity.Passenger;

public interface PassengerDoa {
	void savePassenger(Passenger passenger);
	boolean login(String userName,String password);
	Passenger getPassenger(int id);
	Passenger updatePassenger(int id,Passenger passenger);
	void deletePassenger(int id)throws PersistenceException;
	Passenger getPassengerByEmail(String pEmail);

}
