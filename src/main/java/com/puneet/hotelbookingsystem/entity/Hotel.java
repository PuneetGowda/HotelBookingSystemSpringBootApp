package com.puneet.hotelbookingsystem.entity;

import java.util.List;

import jakarta.persistence.Id;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//This class is entity having hotel detail fields, getters and setters, and to String method
@Entity
@Table(name = "hotel")
@NamedQueries(value= {
		@NamedQuery(name="DELETE_HOTEL", query="delete from Hotel h where h.hotel_id=:hotel_id")
})
public class Hotel {

	// Defining the fields and map them to columns
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hotel_id")
	private int hotel_id;

	@Column(name = "hotel_name")
	private String hotel_name;

	@Column(name = "hotel_location")
	private String hotel_location;

	@Column(name = "hotel_phone")
	private String hotel_phone;

	@Column(name = "hotel_rating")
	private int hotel_rating;

	@Column(name = "hotel_email")
	private String hotel_email;

	@Column(name = "pet_friendly")
	private boolean pet_friendly;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel", cascade = CascadeType.ALL)
	List<HotelCustomer> customers;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel", cascade = CascadeType.ALL)
	List<Room> rooms;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel", cascade = CascadeType.ALL)
	List<Employee> employees;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel", cascade =  CascadeType.ALL)
	List<Booking> bookings;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel", cascade = CascadeType.ALL)
	List<HotelService> services;

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

	public int getHotel_rating() {
		return hotel_rating;
	}

	public void setHotel_rating(int hotel_rating) {
		this.hotel_rating = hotel_rating;
	}

	public String getHotel_email() {
		return hotel_email;
	}

	public void setHotel_email(String hotel_email) {
		this.hotel_email = hotel_email;
	}

	public boolean isPet_friendly() {
		return pet_friendly;
	}

	public void setPet_friendly(boolean pet_friendly) {
		this.pet_friendly = pet_friendly;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public List<HotelCustomer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<HotelCustomer> customers) {
		this.customers = customers;
	}

	public List<HotelService> getServices() {
		return services;
	}

	public void setServices(List<HotelService> services) {
		this.services = services;
	}
	
	@Override
	public String toString() {
		return "Hotel [hotel_id=" + hotel_id + ", hotel_name=" + hotel_name + ", hotel_location=" + hotel_location
				+ ", hotel_phone=" + hotel_phone + ", hotel_rating=" + hotel_rating + ", hotel_email=" + hotel_email
				+ ", pet_friendly=" + pet_friendly + "]";
	}
}
