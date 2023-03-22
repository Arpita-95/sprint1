package com.ems.vc.service;

import java.time.LocalDate;

import com.ems.vc.model.TicketBookingDTO;

public interface TicketService {
	TicketBookingDTO bookFlight(int flight_id,LocalDate date,String pEmail,int no_of_passenger,String airName);
	void cancelBooking(int id);
	TicketBookingDTO getTicket(int id);
}
