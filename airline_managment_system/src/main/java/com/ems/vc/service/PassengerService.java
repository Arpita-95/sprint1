package com.ems.vc.service;

import com.ems.vc.entity.Passenger;
import com.ems.vc.exception.GlobalException;
import com.ems.vc.model.PassengerDTO;
import javax.persistence.PersistenceException;

public interface PassengerService {
      void savePassenger(Passenger passenger);
      boolean login(String userName,String password);
      PassengerDTO getPassengerById(int id)throws GlobalException;
      PassengerDTO updatePassenger(int id,Passenger passenger);
      void deletePassenger(int id)throws PersistenceException;
      
}
