package com.ems.vc.dao;
import java.time.LocalDate;

import com.ems.vc.*;
import com.ems.vc.entity.Airline;
import com.ems.vc.entity.Flight;
import com.ems.vc.entity.Passenger;
import com.ems.vc.entity.TicketBooking;
import com.ems.vc.*;
import com.ems.vc.*;
import com.ems.vc.*;

public interface TicketDAO {
	TicketBooking bookFlight(Airline airline,Passenger p,LocalDate date,Flight f,int no_of_passenger,float total_fare,int avilable_seat);
	void cancelBooking(int id);
	TicketBooking getTicket(int id);

}
