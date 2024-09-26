package com;

public class Passenger {
	
	public String getPassengerId() {
		return passengerId;
	}
	public String getName() {
		return name;
	}
	public Passenger(String passengerId, String name) {
		super();
		this.passengerId = passengerId;
		this.name = name;
	}
	private String passengerId;
	private String name;
	

}
