package com.ems.vc.model;

import java.time.LocalDate;

import com.ems.vc.entity.Airline;
import com.ems.vc.entity.Flight;
import com.ems.vc.entity.Passenger;

import lombok.Data;
@Data
public class TicketBookingDTO {
	private int ticketId;
	private int no_of_passenger;
	private double totalFare;
	private LocalDate date;
	private Flight fid;
	private Airline aid;
	private Passenger pid;


}
