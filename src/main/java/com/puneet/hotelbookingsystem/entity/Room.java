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
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

//This class is entity having room detail fields, getters and setters, and to String method
@Entity
@Table(name="room")
@NamedQueries(value= {
		@NamedQuery(name="GET_ALL_ROOMS_OF_HOTEL", query="select r.room_id, r.room_type, r.room_price, r.room_no, r.floor_no, r.area_of_room, r.occupancy_details from Room r where r.hotel.hotel_id=:hotel_id")
})
public class Room {

	// Defining the fields and mapping them to columns
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="room_id")
	private int room_id;

	@Column(name="room_type")
	private String room_type;

	@Column(name="room_price")
	private float room_price;

	@Column(name="room_no")
	private int room_no;

	@Column(name="floor_no")
	private int floor_no;

	@Column(name="area_of_room")
	private String area_of_room;

	@Column(name="occupancy_details")
	private String occupancy_details;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="hotel_id")
	private Hotel hotel;
	
	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public String getRoom_type() {
		return room_type;
	}

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}

	public float getRoom_price() {
		return room_price;
	}

	public void setRoom_price(float room_price) {
		this.room_price = room_price;
	}

	public int getRoom_no() {
		return room_no;
	}

	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}

	public int getFloor_no() {
		return floor_no;
	}

	public void setFloor_no(int floor_no) {
		this.floor_no = floor_no;
	}

	public String getArea_of_room() {
		return area_of_room;
	}

	public void setArea_of_room(String area_of_room) {
		this.area_of_room = area_of_room;
	}

	public String getOccupancy_details() {
		return occupancy_details;
	}

	public void setOccupancy_details(String occupancy_details) {
		this.occupancy_details = occupancy_details;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	@Override
	public String toString() {
		return "Room [room_id=" + room_id + ", room_type=" + room_type + ", room_price=" + room_price + ", room_no="
				+ room_no + ", floor_no=" + floor_no + ", area_of_room=" + area_of_room + ", occupancy_details="
				+ occupancy_details + "]";
	}
}
