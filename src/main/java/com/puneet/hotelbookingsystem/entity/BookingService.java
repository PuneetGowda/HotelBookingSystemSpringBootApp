package com.puneet.hotelbookingsystem.entity;

import jakarta.persistence.Id;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// This class have the booking and hotel service details
@Entity
@Table(name = "booking_service")
public class BookingService {

	// Defining the fields and mapping them to columns
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_service_id")
	private int booking_service_id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinColumn(name = "booking_id")
	private Booking booking;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinColumn(name = "hotel_service_id")
	private HotelService hotel_service;

	@Column(name = "rating")
	private float service_rating;
	
	public int getBooking_service_id() {
		return booking_service_id;
	}

	public void setBooking_service_id(int booking_service_id) {
		this.booking_service_id = booking_service_id;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public HotelService getHotel_service() {
		return hotel_service;
	}

	public void setHotel_service(HotelService hotel_service) {
		this.hotel_service = hotel_service;
	}

	public float getService_rating() {
		return service_rating;
	}

	public void setService_rating(float service_rating) {
		this.service_rating = service_rating;
	}

	@Override
	public String toString() {
		return "Booking_Service [booking_service_id=" + booking_service_id + ", service_rating=" + service_rating + "]";
	}
}
