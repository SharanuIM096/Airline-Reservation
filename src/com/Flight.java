package com;

public class Flight {
	private String flightId;
	private String origin;
	private String destination;
	private int avaialbleSeats;
	private int totalSeats;
	
	public Flight(String flightId, String origin, String destination,  int totalSeats) {
		super();
		this.flightId = flightId;
		this.origin = origin;
		this.destination = destination;
		this.totalSeats = totalSeats;
		this.avaialbleSeats = totalSeats;
		
	}

	public String getFlightId() {
		return flightId;
	}

	public String getOrigin() {
		return origin;
	}

	public String getDestination() {
		return destination;
	}

	public int getAvaialbleSeats() {
		return avaialbleSeats;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public boolean bookSeat() {
		if(avaialbleSeats>0) {
			avaialbleSeats--;
			return true;
		}
		return false;
	}
	
	public boolean cancelSeat() {
		if(avaialbleSeats<totalSeats) {
			avaialbleSeats++;
			return true;
		}
		return false;
	}
	
	

}
