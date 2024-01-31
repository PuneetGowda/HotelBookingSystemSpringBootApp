package com.puneet.hotelbookingsystem.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.puneet.hotelbookingsystem.entity.BookingStatus;
import com.puneet.hotelbookingsystem.observer.BookingObserver;

// This class is a DTO to transfer list of bookings of a hotel
public class BookingDTO {

	// Define the fields
	private int booking_id;

	private String customer_name;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date booking_date_time;

	private double booking_amount;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date check_in_date_time;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date check_out_date_Time;

	private BookingStatus booking_status;

	private int room_no;

	private String employee_name;

	private Integer no_of_adults;

	private Integer no_of_child;

	private List<BookingObserver> observers = new ArrayList<>();

	public void attach(BookingObserver observer) {
		observers.add(observer);
	}

	public void detach(BookingObserver observer) {
		observers.remove(observer);
	}

	// Generate getters and setters
	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public Date getBooking_date_time() {
		return booking_date_time;
	}

	public void setBooking_date_time(Date booking_date_time) {
		this.booking_date_time = booking_date_time;
	}

	public double getBooking_amount() {
		return booking_amount;
	}

	public void setBooking_amount(double booking_amount) {
		this.booking_amount = booking_amount;
	}

	public Date getCheck_in_date_time() {
		return check_in_date_time;
	}

	public void setCheck_in_date_time(Date check_in_date_time) {
		this.check_in_date_time = check_in_date_time;
	}

	public Date getCheck_out_date_Time() {
		return check_out_date_Time;
	}

	public void setCheck_out_date_Time(Date check_out_date_Time) {
		this.check_out_date_Time = check_out_date_Time;
	}

	public BookingStatus getBooking_status() {
		return booking_status;
	}

	public void setBooking_status(BookingStatus booking_status) {
		this.booking_status = booking_status;
	}

	public int getRoom_no() {
		return room_no;
	}

	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
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

	// Generate toString method
	@Override
	public String toString() {
		return "BookingDTO [booking_id=" + booking_id + ", customer_name=" + customer_name + ", booking_date_time="
				+ booking_date_time + ", booking_amount=" + booking_amount + ", check_in_date_time="
				+ check_in_date_time + ", check_out_date_Time=" + check_out_date_Time + ", booking_status="
				+ booking_status + ", room_no=" + room_no + ", employee_name=" + employee_name + ", no_of_adults="
				+ no_of_adults + ", no_of_child=" + no_of_child + "]";
	}

}
