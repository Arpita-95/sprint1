package com.ems.vc.service;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.PersistenceException;

import com.ems.vc.entity.Flight;
import com.ems.vc.model.FlightDTO;

public interface FlightService {
	void saveFlight(Flight flight);
	FlightDTO updateFlight(int id,Flight flight);
	FlightDTO getFlight(int id);
	void deleteFlight(int id)throws PersistenceException;
	List<Flight> checkFlight(String from,String to,LocalDate date);

}
