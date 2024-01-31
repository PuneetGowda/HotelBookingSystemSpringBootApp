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



//This class is entity having hotel customer detail fields, getters and setters, and to String method
@Entity
@Table(name="hotel_customer")
public class HotelCustomer {

	// Defining the fields and map them to columns
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="hotel_customer_id")
	private int hotel_customer_id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinColumn(name="hotel_id")
	private Hotel hotel;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@Column(name="customer_type")
	private String customer_type;
	
	@Column(name="customer_reward_points")
	private double customer_reward_points;
	
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getCustomer_type() {
		return customer_type;
	}

	public void setCustomer_type(String customer_type) {
		this.customer_type = customer_type;
	}

	public double getCustomer_reward_points() {
		return customer_reward_points;
	}

	public void setCustomer_reward_points(double customer_reward_points) {
		this.customer_reward_points = customer_reward_points;
	}

	@Override
	public String toString() {
		return "Hotel_Customer [hotel_customer_id=" + hotel_customer_id + ", customer_type=" + customer_type
				+ ", customer_reward_points=" + customer_reward_points + "]";
	}
}
