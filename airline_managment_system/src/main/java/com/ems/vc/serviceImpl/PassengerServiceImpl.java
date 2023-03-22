package com.ems.vc.serviceImpl;

import javax.persistence.PersistenceException;

import org.modelmapper.ModelMapper;

import com.ems.vc.dao.PassengerDoa;
import com.ems.vc.daoimpl.PassengerDaoImpl;
import com.ems.vc.entity.Passenger;
import com.ems.vc.exception.GlobalException;
import com.ems.vc.model.PassengerDTO;
import com.ems.vc.service.PassengerService;

public class PassengerServiceImpl implements PassengerService {
	
	PassengerDoa pdao=new PassengerDaoImpl();
	@Override
	public void savePassenger(Passenger passenger) {
		pdao.savePassenger(passenger);
		
	}

	@Override
	public boolean login(String userName, String password) {
		
		return pdao.login(userName, password);
	}

	@Override
	public PassengerDTO getPassengerById(int id) throws GlobalException {
		Passenger  passenger1=pdao.getPassenger(id);
		
		return new ModelMapper().map(passenger1, 
				PassengerDTO.class);
	}

	@Override
	public PassengerDTO updatePassenger(int id, Passenger passenger) {
		Passenger p=pdao.updatePassenger(id, passenger);
		return new ModelMapper().map(p, PassengerDTO.class);
	}

	@Override
	public void deletePassenger(int id) throws PersistenceException {
		pdao.deletePassenger(id);
		
		
	}

}
