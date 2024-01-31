package com.puneet.hotelbookingsystem.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Id;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

// This class is the entity having booking details
@Entity
@Table(name="booking")
@NamedQueries(value= {
		@NamedQuery(name="GET_ALL_BOOKINGS_OF_HOTEL", query="select b.booking_id, b.booking_dateTime, b.booking_amt, b.check_in_DateTime, b.check_out_DateTime, b.no_of_adults, b.no_of_child, b.booking_status from Booking b where b.hotel.hotel_id =:hotel_id")
})
public class Booking {

	// Defining the fields & annotate the fields
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="booking_id")
	private int booking_id;

	@Column(name="booking_dateTime")
	private Date booking_dateTime;

	@Column(name="booking_amt")
	private double booking_amt;

	@Column(name="check_in_DateTime")
	private Date check_in_DateTime;

	@Column(name="check_out_DateTime")
	private Date check_out_DateTime;

	@Column(name="no_of_adults")
	private Integer no_of_adults;

	@Column(name="no_of_child")
	private Integer no_of_child;
	
	@Column(name="booking_status")
	@Enumerated(EnumType.STRING)
	private BookingStatus booking_status;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="hotel_id")
	private Hotel hotel;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="customer_id")
	private Customer customer;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "room_id")
	private Room room;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="emp_id")
	private Employee employee;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bill_id")
	private Bill bill;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "booking", cascade = CascadeType.ALL)
	List<BookingService> services;

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public Date getBooking_dateTime() {
		return booking_dateTime;
	}

	public void setBooking_dateTime(Date booking_dateTime) {
		this.booking_dateTime = booking_dateTime;
	}

	public double getBooking_amt() {
		return booking_amt;
	}

	public void setBooking_amt(double booking_amt) {
		this.booking_amt = booking_amt;
	}

	public Date getCheck_in_DateTime() {
		return check_in_DateTime;
	}

	public void setCheck_in_DateTime(Date check_in_DateTime) {
		this.check_in_DateTime = check_in_DateTime;
	}

	public Date getCheck_out_DateTime() {
		return check_out_DateTime;
	}

	public void setCheck_out_DateTime(Date check_out_DateTime) {
		this.check_out_DateTime = check_out_DateTime;
	}

	public Integer getNo_of_adults() {
		return no_of_adults;
	}

	public void setNo_of_adults(Integer no_of_adults) {
		this.no_of_adults = no_of_adults;
	}

	public Integer getNo_of_child() {
		return no_of_child;
	}

	public void setNo_of_child(Integer no_of_child) {
		this.no_of_child = no_of_child;
	}

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

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public BookingStatus getBooking_status() {
		return booking_status;
	}

	public void setBooking_status(BookingStatus booking_status) {
		this.booking_status = booking_status;
	}

	public List<BookingService> getServices() {
		return services;
	}

	public void setServices(List<BookingService> services) {
		this.services = services;
	}

	@Override
	public String toString() {
		return "Booking [booking_id=" + booking_id + ", booking_dateTime=" + booking_dateTime + ", booking_amt="
				+ booking_amt + ", check_in_DateTime=" + check_in_DateTime + ", check_out_DateTime="
				+ check_out_DateTime + ", no_of_adults=" + no_of_adults + ", no_of_child=" + no_of_child
				+ ", booking_status=" + booking_status + "]";
	}	
}
