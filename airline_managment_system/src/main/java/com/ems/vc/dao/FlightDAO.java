package com.ems.vc.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.PersistenceException;

import com.ems.vc.entity.Flight;

public interface FlightDAO {
	void saveFlight(Flight flight);
	Flight updateFlight(int id,Flight flight);
	Flight getFlight(int id);
	void deleteFlight(int id)throws PersistenceException;
	List<Flight> checkFlight(String from,String to,LocalDate date);

}
