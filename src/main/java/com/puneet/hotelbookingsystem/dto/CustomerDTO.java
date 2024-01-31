package com.puneet.hotelbookingsystem.dto;

// This class is a DTO to transfer the list of Customers
public class CustomerDTO {

	// Define the fields
	private int customer_id;
	
	private String customer_name;
	
	private String customer_phone;
	
	private String customer_email;
	
	private String customer_address;
	
	private String customer_preferences;
	
	private String customer_special_needs;

	// Generate getters and setters
	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_phone() {
		return customer_phone;
	}

	public void setCustomer_phone(String customer_phone) {
		this.customer_phone = customer_phone;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public String getCustomer_address() {
		return customer_address;
	}

	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}

	public String getCustomer_preferences() {
		return customer_preferences;
	}

	public void setCustomer_preferences(String customer_preferences) {
		this.customer_preferences = customer_preferences;
	}

	public String getCustomer_special_needs() {
		return customer_special_needs;
	}

	public void setCustomer_special_needs(String customer_special_needs) {
		this.customer_special_needs = customer_special_needs;
	}

	// Generate toString method
	@Override
	public String toString() {
		return "CustomerDTO [customer_id=" + customer_id + ", customer_name=" + customer_name + ", customer_phone="
				+ customer_phone + ", customer_email=" + customer_email + ", customer_address=" + customer_address
				+ ", customer_preferences=" + customer_preferences + ", customer_special_needs="
				+ customer_special_needs + "]";
	}
	
	
}
