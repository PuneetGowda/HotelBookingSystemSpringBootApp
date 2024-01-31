package com.puneet.hotelbookingsystem.dto;

// This class is a DTO to transfer list of rooms of a hotel 
public class RoomDTO {

	// Define the fields
	private int room_id;
	
	private String room_type;
	
	private float room_price;
	
	private int room_no;
	
	private int floor_no;
	
	private String room_area;
	
	private String room_occupancy_details;

	// Generate getters and setters
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

	public String getRoom_area() {
		return room_area;
	}

	public void setRoom_area(String room_area) {
		this.room_area = room_area;
	}

	public String getRoom_occupancy_details() {
		return room_occupancy_details;
	}

	public void setRoom_occupancy_details(String room_occupancy_details) {
		this.room_occupancy_details = room_occupancy_details;
	}

	// Generate toString method
	@Override
	public String toString() {
		return "RoomDTO [room_id=" + room_id + ", room_type=" + room_type + ", room_price=" + room_price + ", room_no="
				+ room_no + ", floor_no=" + floor_no + ", room_area=" + room_area + ", room_occupancy_details="
				+ room_occupancy_details + "]";
	}
	
	
}
