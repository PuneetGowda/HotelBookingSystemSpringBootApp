package com.puneet.hotelbookingsystem.dto;

import java.util.List;

// This class is a DTO to transfer hotel information 
public class HotelInformationDTO {
	
	// Define the fields
	private int hotel_id;
	
	private String hotel_name;
	
	private String hotel_location;
	
	private String hotel_phone;
	
	private String hotel_email;
	
	private int hotel_rating;
	
	private boolean pet_friendly;
	
	private List<Integer> hotel_customer;
	
	private List<Integer> hotel_room;

	private List<Integer> hotel_employee;
	
	private List<Integer> hotel_service;
	
	private List<Integer> hotel_booking;

	// Create getters and setters
	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getHotel_name() {
		return hotel_name;
	}

	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}

	public String getHotel_location() {
		return hotel_location;
	}

	public void setHotel_location(String hotel_location) {
		this.hotel_location = hotel_location;
	}

	public String getHotel_phone() {
		return hotel_phone;
	}

	public void setHotel_phone(String hotel_phone) {
		this.hotel_phone = hotel_phone;
	}

	public String getHotel_email() {
		return hotel_email;
	}

	public void setHotel_email(String hotel_email) {
		this.hotel_email = hotel_email;
	}

	public int getHotel_rating() {
		return hotel_rating;
	}

	public void setHotel_rating(int hotel_rating) {
		this.hotel_rating = hotel_rating;
	}

	public boolean isPet_friendly() {
		return pet_friendly;
	}

	public void setPet_friendly(boolean pet_friendly) {
		this.pet_friendly = pet_friendly;
	}

	public List<Integer> getHotel_customer() {
		return hotel_customer;
	}

	public void setHotel_customer(List<Integer> hotel_customer) {
		this.hotel_customer = hotel_customer;
	}

	public List<Integer> getHotel_room() {
		return hotel_room;
	}

	public void setHotel_room(List<Integer> hotel_room) {
		this.hotel_room = hotel_room;
	}

	public List<Integer> getHotel_employee() {
		return hotel_employee;
	}

	public void setHotel_employee(List<Integer> hotel_employee) {
		this.hotel_employee = hotel_employee;
	}

	public List<Integer> getHotel_service() {
		return hotel_service;
	}

	public void setHotel_service(List<Integer> hotel_service) {
		this.hotel_service = hotel_service;
	}

	public List<Integer> getHotel_booking() {
		return hotel_booking;
	}

	public void setHotel_booking(List<Integer> hotel_booking) {
		this.hotel_booking = hotel_booking;
	}

	// Generate toString method
	@Override
	public String toString() {
		return "HotelInformationDTO [hotel_id=" + hotel_id + ", hotel_name=" + hotel_name + ", hotel_location="
				+ hotel_location + ", hotel_phone=" + hotel_phone + ", hotel_email=" + hotel_email + ", hotel_rating="
				+ hotel_rating + ", pet_friendly=" + pet_friendly + ", hotel_customer=" + hotel_customer
				+ ", hotel_room=" + hotel_room + ", hotel_employee=" + hotel_employee + ", hotel_service="
				+ hotel_service + ", hotel_booking=" + hotel_booking + "]";
	}
	
	

}
