package com;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class ReservationSystem {
	
	private static Map<String ,Flight> flights=new HashMap<>();
	private static Map<String ,Passenger> passenger=new HashMap<>();
	private static Map<String ,Reservation> reservation=new HashMap<>();
	
	
	
	public static void addFlight(String flightId,String origin,String destination,int totalSeats) {
		
		flights.put(flightId, new Flight(flightId,origin,destination,totalSeats));
	}
	
	public static void addPassenger(String passengerId,String name) {
		passenger.put(passengerId, new Passenger(passengerId, name));
		
	}
	
	public static String bookReservation(String flightId,String passengerId) {
	Flight flight=flights.get(flightId);
	Passenger passengers=passenger.get(passengerId);
	
	if(flight==null) {
		return "flight is not found";
	}
	if(passengers==null) {
		return "passenger is not found";
	}
	if(flight.bookSeat()) {
		 String bookingId = UUID.randomUUID().toString();
		 
		 Reservation reservations=new Reservation(bookingId, flight, passengers);
		 
		 reservation.put(bookingId, reservations);
		 return "booking is conformed "+bookingId;
	}
	
		return "no seat available";
	
	}
	
	public static String cancelReservation(String bookingid) {
	Reservation reservations=reservation.remove(bookingid);
	
	if(reservations!=null) {
		reservations.getFlight().cancelSeat();
		return "reservation is cancelled";
	}
	else {
		return "reservation is not found";
	}	
	}
	
	public static void displayReservation() {
	
		for(Reservation reservations:reservation.values()) {
			System.out.println(reservations.getBookingId());
			System.out.println(reservations.getFlight().getFlightId());
			System.out.println(reservations.getPassenger().getName());
		}
	}
	
	
	
	
	public void start() {
		
		while(true) {
		     System.out.println("\nAirline Reservation System");
	            System.out.println("1. Add Flight");
	            System.out.println("2. Add Passenger");
	            System.out.println("3. Book Reservation");
	            System.out.println("4. Cancel Reservation");
	            System.out.println("5. View Reservations");
	            System.out.println("6. Exit");
	            System.out.print("Choose an option: ");
	            
	            Scanner sc= new Scanner(System.in);
	            int choice=sc.nextInt();
	            sc.nextLine();
	            
	            switch(choice) {
	            case 1:
	            	System.out.println("Enter the flight Id");
	            	String flightId=sc.nextLine();
	            	System.out.println("Enter the Origin");
	            	String origin=sc.nextLine();
	            	System.out.println("enter the destination");
	            	String destination=sc.nextLine();
	            	System.out.println("Enter the Total seats");
	            	int totalSeats=sc.nextInt();
	            	sc.nextLine();
	            	addFlight(flightId, origin, destination, totalSeats);
	            	System.out.println("Flight added SuscessFully");
	            	break;
	            	
	            case 2:
	            	System.out.println("Enter the passengerID");
	            	String passengerId=sc.nextLine();
	            	System.out.println("Enter the passenger Name");
	            	String name=sc.nextLine();
	            	addPassenger(passengerId, name);
	            	System.out.println("passeneger added sucessfully");
	            	break;
	            	
	            case 3:
	            	System.out.println("Enter the FlightId");
	            	String bookFlightId=sc.nextLine();
	            	System.out.println("enter the passengerID");
	            	String bookPassengerID=sc.nextLine();
	            	String bookingId=bookReservation(bookFlightId, bookPassengerID);
	            	System.out.println(bookingId);
	            	break;
	            	
	            	
	            	
	            case 4:
	            	System.out.println("Enter your Booking Id");
	            	String bookingid=sc.nextLine();
	            	String status=cancelReservation(bookingid);
	            	System.out.println(status);
	               	break;
	            	
	            case 5:
	            	System.out.println("bookings are below");
	            	displayReservation();
	               	break;
	            	
	            case 6:System.exit(0);
	           	     break;
	  	
	            }
		}
		
	}
	public static void main(String[] args) {
		ReservationSystem system= new ReservationSystem();
		system.start();
	}

}
