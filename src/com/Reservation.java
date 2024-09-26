package com;

public class Reservation {
	
  public String getBookingId() {
		return bookingId;
	}
	public Flight getFlight() {
		return flight;
	}
	public Passenger getPassenger() {
		return passenger;
	}
public Reservation(String bookingId, Flight flight, Passenger passenger) {
		super();
		this.bookingId = bookingId;
		this.flight = flight;
		this.passenger = passenger;
	}
private String bookingId;
  private Flight flight;
  private Passenger passenger;
  
  

}
