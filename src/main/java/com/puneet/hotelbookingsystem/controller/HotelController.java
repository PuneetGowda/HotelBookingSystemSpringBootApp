package com.puneet.hotelbookingsystem.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.puneet.hotelbookingsystem.dto.BookingDTO;
import com.puneet.hotelbookingsystem.dto.CustomerDTO;
import com.puneet.hotelbookingsystem.dto.EmployeeDTO;
import com.puneet.hotelbookingsystem.dto.HotelDTO;
import com.puneet.hotelbookingsystem.dto.HotelInformationDTO;
import com.puneet.hotelbookingsystem.dto.RoomDTO;
import com.puneet.hotelbookingsystem.dto.ServiceDTO;
import com.puneet.hotelbookingsystem.entity.Hotel;
import com.puneet.hotelbookingsystem.service.IHotelService;

// This class is a controller that maps the request to methods for getting list of hotels
@CrossOrigin(origins="*", maxAge=3600)
@RestController
@RequestMapping("/api")
public class HotelController {

	// Create Logger object
	private static Logger logger = LogManager.getLogger(HotelController.class);
	
	// Inject the hotel service interface
	private IHotelService hotelService;
	
	@Autowired
	public HotelController(IHotelService hotelService) {
		this.hotelService = hotelService;
	}
	
	public HotelController() {}
	
	// This method return list of hotels, return type is List<HotelDTO>
	@GetMapping("/hotels")
	public List<HotelDTO> getListOfHotels(@RequestParam(value="hotel_name", required=false) String hotel_name) {

		logger.info("Inside controller");
	
		// Get the list of hotels by calling the getListOfHotels method of hotel service
		List<HotelDTO> hotels = hotelService.getListOfHotels(hotel_name);
		
		// Return the list of hotel
		return hotels;
	}
	
	// This method returns hotel information, return type is HotelInformationDTO
	@GetMapping("/hotels/{hotel_id}")
	public HotelInformationDTO getHotelInformation(@PathVariable("hotel_id") int hotel_id) {
		
		logger.info("Inside hotel information controller");
		
		// Call the getAHotelInformation of hotel service to get the hotel information
		HotelInformationDTO hotel = hotelService.getHotelInformation(hotel_id);
		
		// Return the hotel
		return hotel;
	}
	
	// This method returns the list of customers of a hotel, return type is List<CustomerDTO>
	@GetMapping("/hotels/{hotel_id}/customers")
	public List<CustomerDTO> getAllCustomersOfHotel(@PathVariable("hotel_id") int hotel_id) {
		
		logger.info("Inside hotel customer controller");
		
		// Call the getAllCustomersOfHotel method of hotel service to get the customers
		List<CustomerDTO> customers = hotelService.getAllCustomersOfHotel(hotel_id);
		
		// Return the customers
		return customers;
	}
	
	// This method return the list of bookings of a hotel, return type is List<BookingDTO>
	@GetMapping("/hotels/{hotel_id}/bookings")
	public List<BookingDTO> getAllBookingsOfHotel(@PathVariable("hotel_id") int hotel_id) {
		
		logger.info("Inside hotel booking controller");
		
		// Call the getAllBookingsOfHotel method of hotel service to get the list of bookings
		List<BookingDTO> bookings = hotelService.getAllBookingsOfHotel(hotel_id);
		
		// Return the bookings
		return bookings;
	}
	
	// This method returns the list of services of a hotel, return type is List<ServiceDTO>
	@GetMapping("/hotels/{hotel_id}/services")
	public List<ServiceDTO> getAllServicesOfHotel(@PathVariable("hotel_id") int hotel_id) {
		
		logger.info("Inside hotel service controller");
		
		// Call the getAllServicesOfHotel method of hotel service
		List<ServiceDTO>  services = hotelService.getAllServicesOfHotel(hotel_id);
	
		// Return the services
		return services;
	}
	
	// This method return list of employees of a hotel, return type is List<EmployeeDTO>
	@GetMapping("/hotels/{hotel_id}/employees")
	public List<EmployeeDTO> getAllEmployeesOfHotel(@PathVariable("hotel_id") int hotel_id) {
		
		logger.info("Inside hotel employee controller");
		
		// Call the getAllEmployeesOfHotel method of hotel service to get the employees
		List<EmployeeDTO> employees = hotelService.getAllEmployeesOfHotel(hotel_id);
		
		// Return the list of employee dto
		return employees;
	}
	
	// This method return list of all the rooms of a hotel, return type is List<RoomDTO>
	@GetMapping("/hotels/{hotel_id}/rooms")
	public List<RoomDTO> getAllRoomsOfHotel(@PathVariable("hotel_id") int hotel_id) {
		
		logger.info("Inside hotel room controller");
		
		// Call the getAllRoomsOfHotel method of hotel service to all the rooms of hotel
		List<RoomDTO> rooms = hotelService.getAllRoomsOfHotel(hotel_id);
		
		// Return the list of rooms
		return rooms;
	}
	
	// This method adds a new hotel, return type is boolean
	@PostMapping("/hotels")
	public String addNewHotel(@RequestBody Hotel hotel) {
		
		logger.info("Inside add new hotel controller");
		
		// Call the addNewHotel of hotel service with hotel object as argument 
		String wasHotelAdded = hotelService.addNewHotel(hotel);
		
		// Return the boolean flag whether the hotel was added
		return wasHotelAdded;
	}
	
	// This method updates a hotel, return type is boolean
	@PutMapping("/hotels/{hotel_id}")
	public boolean editHotel(@PathVariable("hotel_id") int hotel_id, @RequestBody Hotel hotel) {
		
		logger.info("Inside edit hotel controller");
		
		// Call the editAHotel method of hotel service with hotel id and hotel object as arguments
		boolean editedHotel = hotelService.editHotel(hotel_id, hotel);
		
		// Return the boolean flag indicating whether the hotel was updated
		return editedHotel;
	}
	
	// This method deletes a hotel, return type is boolean
	@DeleteMapping("/hotels/{hotel_id}")
	public boolean deleteHotel(@PathVariable("hotel_id") int hotel_id) {
		
		logger.info("Inside delete hotel controller");
		
		// Call the deleteAHotel method of hotel service to delete the hotel
		boolean isDeleted = hotelService.deleteHotel(hotel_id);
		
		// Return the boolean flag
		return isDeleted;
	}
}
