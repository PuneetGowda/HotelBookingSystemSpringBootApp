package com.puneet.hotelbookingsystem.dto;

import java.math.BigDecimal;

// This class is a DTO to transfer list of service of a hotel
public class ServiceDTO {

	// Define the fields
	private int service_id;
		
	private String service_name;
	
	private BigDecimal service_price;

	// Generate getters and setters
	public int getService_id() {
		return service_id;
	}

	public void setService_id(int service_id) {
		this.service_id = service_id;
	}

	public String getService_name() {
		return service_name;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	public BigDecimal getService_price() {
		return service_price;
	}

	public void setService_price(BigDecimal service_price) {
		this.service_price = service_price;
	}

	// Generate toString method
	@Override
	public String toString() {
		return "ServiceDTO [service_id=" + service_id + ", service_name=" + service_name + ", service_price="
				+ service_price + "]";
	}
	
	
}
