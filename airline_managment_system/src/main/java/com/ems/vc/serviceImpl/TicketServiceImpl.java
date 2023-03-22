package com.ems.vc.serviceImpl;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;

import com.ems.vc.dao.AirlineDAO;
import com.ems.vc.dao.FlightDAO;
import com.ems.vc.dao.PassengerDoa;
import com.ems.vc.dao.TicketDAO;
import com.ems.vc.daoimpl.AirlineDAOImpl;
import com.ems.vc.daoimpl.FlightDAOImpl;
import com.ems.vc.daoimpl.PassengerDaoImpl;
import com.ems.vc.daoimpl.TicketDaoImpl;
import com.ems.vc.entity.Airline;
import com.ems.vc.entity.Flight;
import com.ems.vc.entity.Passenger;
import com.ems.vc.entity.TicketBooking;
import com.ems.vc.exception.GlobalException;
import com.ems.vc.model.TicketBookingDTO;
import com.ems.vc.service.TicketService;

public class TicketServiceImpl implements TicketService {
	FlightDAO fdao=new FlightDAOImpl();
	AirlineDAO adao=new AirlineDAOImpl();
	PassengerDoa pdao=new PassengerDaoImpl();
	TicketDAO tdao=new TicketDaoImpl();

	@Override
	public TicketBookingDTO bookFlight(int flight_id, LocalDate date, String pEmail, int no_of_passenger,
			String airName) {
		Flight flight=fdao.getFlight(flight_id);
		if(flight.getAvilableSeats()>no_of_passenger)
		{
			Passenger p=pdao.getPassengerByEmail(pEmail);
			Airline airline=adao.getAirlineByName(airName);
			float totalfare=airline.getFare()*no_of_passenger;
			int avilable_seat=(flight.getAvilableSeats()-no_of_passenger);
			TicketBooking bookedTicket=tdao.bookFlight(airline, p, date, flight, no_of_passenger, totalfare, avilable_seat);
		return new ModelMapper().map(bookedTicket,TicketBookingDTO.class);
		}
		return null;
	}

	@Override
	public void cancelBooking(int id) {
		tdao.cancelBooking(id);
		
	}

	@Override
	public TicketBookingDTO getTicket(int id) {
		TicketBooking tick=tdao.getTicket(id);
		if(tick!=null)
			return new ModelMapper().map(tick, TicketBookingDTO.class);
	
	
	throw new GlobalException("Passenger details not exist!!!");
	
	}
	

}
