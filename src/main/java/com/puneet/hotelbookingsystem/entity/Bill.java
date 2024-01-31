package com.puneet.hotelbookingsystem.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


//This class is entity having bill detail fields, getters and setters, and to String method
@Entity
@Table(name="bill")
public class Bill {

	// Defining the fields and mapping them to columns
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bill_id")
	private int bill_id;

	@Column(name="bill_number")
	private int bill_number;

	@Column(name="bill_amt")
	private float bill_amt;

	@Column(name="bill_DateTime")
	private Date bill_dateTime;

	@Column(name="discount")
	private String discount;

	@Column(name="bill_reward_points")
	private int bill_reward_points;
	
	@Column(name="bill_status")
	@Enumerated(EnumType.STRING)
	private BillStatus bill_status;

	@Column(name="payment_method")
	@Enumerated(EnumType.STRING)
	private PaymentMethod payment_method;

	public int getBill_id() {
		return bill_id;
	}

	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}

	public int getBill_number() {
		return bill_number;
	}

	public void setBill_number(int bill_number) {
		this.bill_number = bill_number;
	}

	public float getBill_amt() {
		return bill_amt;
	}

	public void setBill_amt(float bill_amt) {
		this.bill_amt = bill_amt;
	}

	public Date getBill_dateTime() {
		return bill_dateTime;
	}

	public void setBill_dateTime(Date bill_dateTime) {
		this.bill_dateTime = bill_dateTime;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public int getBill_reward_points() {
		return bill_reward_points;
	}

	public void setBill_reward_points(int bill_reward_points) {
		this.bill_reward_points = bill_reward_points;
	}

	@Override
	public String toString() {
		return "Bill [bill_id=" + bill_id + ", bill_number=" + bill_number + ", bill_amt=" + bill_amt
				+ ", bill_dateTime=" + bill_dateTime + ", discount=" + discount + ", bill_reward_points="
				+ bill_reward_points + "]";
	}
}
