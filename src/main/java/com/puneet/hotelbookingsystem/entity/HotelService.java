package com.puneet.hotelbookingsystem.entity;

import java.math.BigDecimal;

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

//This class is entity having hotel service detail fields, getters and setters, and to String method
@Entity
@Table(name="hotel_service")
public class HotelService {

	// Defining the fields and map them to columns
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="hotel_service_id")
	private int hotel_service_id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinColumn(name="hotel_id")
	private Hotel hotel;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinColumn(name="service_id")
	private Service service;
	
	@Column(name="service_price")
	private BigDecimal service_price;

	public int getHotel_service_id() {
		return hotel_service_id;
	}

	public void setHotel_service_id(int hotel_service_id) {
		this.hotel_service_id = hotel_service_id;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public BigDecimal getService_price() {
		return service_price;
	}

	public void setService_price(BigDecimal service_price) {
		this.service_price = service_price;
	}

	@Override
	public String toString() {
		return "Hotel_Service [hotel_service_id=" + hotel_service_id + ", service_price=" + service_price + "]";
	}
}
