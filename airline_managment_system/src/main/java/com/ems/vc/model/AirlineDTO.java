package com.ems.vc.model;

import java.util.List;


import com.ems.vc.entity.Flight;

import lombok.Data;
@Data
public class AirlineDTO {
	private int id;
	private String airlineName;
	private float fare;
	private List<Flight> flights;

}
