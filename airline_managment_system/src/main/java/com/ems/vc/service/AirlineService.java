package com.ems.vc.service;

import javax.persistence.PersistenceException;

import com.ems.vc.entity.Airline;
import com.ems.vc.model.AirlineDTO;

public interface AirlineService {
	
	void saveAirline(Airline airline);
	void assignAirlineToFlight(int flightId,int airId);
	AirlineDTO getAirlineByName(String name);
	AirlineDTO updateAirlineById(int id,Airline airline);
	void deleteAirline(int id)throws PersistenceException;

}
