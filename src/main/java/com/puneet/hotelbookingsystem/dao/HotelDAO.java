package com.puneet.hotelbookingsystem.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.puneet.hotelbookingsystem.entity.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

// This class is a repository having methods to get list of hotels
@Repository
public class HotelDAO implements IHotelDAO {

	// Initialize the Logger
	private static Logger logger = LogManager.getLogger(HotelDAO.class);

	// Inject the entity manager
	@Autowired
	private EntityManager entityManager;

	// This method returns the list of hotels
	@Override
	public List<Object[]> getListOfHotels(String hotel_name) {

		// Native Query to get hotels
		List<Object[]> nativeQuery = null;

		// Create and execute query to get list of hotel objects
		nativeQuery = entityManager.createNativeQuery(
				"SELECT hotel_id, hotel_name, hotel_location, hotel_phone, hotel_email, hotel_rating, pet_friendly FROM hotel WHERE hotel_name LIKE '%"
						+ hotel_name + "%'")
				.getResultList();
		
		// Return the list of hotels
		return nativeQuery;
	}

	// This method returns hotel information
	@Override
	public List<Object[]> getHotelInformation(int hotel_id) {

		List<Object[]> query = null;

			// Create and execute query to get the hotel information object
			query = entityManager.createNativeQuery(
					"SELECT hotel.hotel_id, hotel_name, hotel_location, hotel_phone, hotel_email, hotel_rating, pet_friendly, booking.booking_id, room.room_id, employee.emp_id, hotel_service.service_id, hotel_customer.customer_id FROM hotel JOIN hotel_customer on hotel_customer.hotel_id = hotel.hotel_id JOIN hotel_service on hotel_service.hotel_id = hotel.hotel_id JOIN room on hotel.hotel_id = room.hotel_id JOIN employee on hotel.hotel_id = employee.hotel_id JOIN booking on hotel.hotel_id = booking.hotel_id WHERE hotel.hotel_id="
							+ hotel_id)
					.getResultList();

		// Return the query result
		return query;
	}

	// This method return all customers object of a hotel, return type is
	// List<Object[]>
	@Override
	public List<Object[]> getAllCustomersOfHotel(int hotel_id) {

		List<Object[]> hotelCustomers = null;

			// Create named query and set the hotel id parameter
			Query query = entityManager.createNamedQuery("GET_ALL_CUSTOMERS_OF_HOTEL");
			query.setParameter("hotel_id", hotel_id);

			// Execute the named query
			hotelCustomers = query.getResultList();

		// Return the list of customer objects
		return hotelCustomers;
	}

	// This method returns list of bookings object of a hotel
	@Override
	public List<Object[]> getAllBookingsOfHotel(int hotel_id) {

		List<Object[]> bookingObjList = null;

			// Create named query to get all bookings of hotel and set parameter of query
			// for hotel id
			Query query = entityManager.createNamedQuery("GET_ALL_BOOKINGS_OF_HOTEL");
			query.setParameter("hotel_id", hotel_id);

			// Get the result list
			bookingObjList = query.getResultList();

		// Return the booking list object
		return bookingObjList;
	}

	// This method return list of service array objects, return type is
	// List<Object[]>
	@Override
	public List<Object[]> getAllServicesOfHotel(int hotel_id) {

		List<Object[]> serviceObjList = null;
	
			// Create named query to get all services of hotel and set parameter hotel_id
			Query query = entityManager.createNamedQuery("GET_ALL_SERVICES_OF_HOTEL");
			query.setParameter("hotel_id", hotel_id);

			// Get the result list
			serviceObjList = query.getResultList();

			logger.info("Inside service dao " + serviceObjList);

		// Return the list
		return serviceObjList;
	}

	// This method returns the list of employee object array, return type is
	// List<Object[]>
	@Override
	public List<Object[]> getAllEmployeesOfHotel(int hotel_id) {

		List<Object[]> employeeObjList = null;

			// Create and execute query to get employees
			employeeObjList = entityManager.createQuery(
					"select e.emp_id, e.emp_name, e.emp_salary, e.emp_phone, e.emp_address, e.emp_email, e.joining_date from Employee e where e.hotel.hotel_id="
							+ hotel_id)
					.getResultList();

		// Return the employee object list
		return employeeObjList;
	}

	// This method returns list of room object array, return type is List<Object[]>
	@Override
	public List<Object[]> getAllRoomsOfHotel(int hotel_id) {

		List<Object[]> roomObjList = null;
		
			// Create named query to get all rooms of hotel and set parameter for hotel id
			Query query = entityManager.createNamedQuery("GET_ALL_ROOMS_OF_HOTEL");
			query.setParameter("hotel_id", hotel_id);

			// Get the list of room object array
			roomObjList = query.getResultList();

		// Return the room object list
		return roomObjList;
	}

	// This dao method adds a new hotel
	@Override
	public boolean addNewHotel(Hotel hotel) {

		// Boolean flag to indicate whether the hotel was added
		boolean wasHotelAdded = false;

			// Call the persist method of entityManager to add a new hotel
			entityManager.persist(hotel);

			// Set the flag to true
			wasHotelAdded = true;

		// Return the boolean flag
		return wasHotelAdded;
	}

	// This method updates a hotel
	@Override
	public boolean editHotel(int hotel_id, Hotel hotel) {

		logger.info("Inside edit hotel");

			// Set the id of the hotel
			hotel.setHotel_id(hotel_id);

			// Call the merge method of entityManager to update the hotel
			entityManager.merge(hotel);
	
		// Return true for successful exection
		return true;
	}

	// This method deletes a hotel
	@Override
	public boolean deleteHotel(int hotel_id) {

			// Create named query to delete a hotel and set hotel id parameter
			Query query = entityManager.createNamedQuery("DELETE_HOTEL");
			query.setParameter("hotel_id", hotel_id);

			// Execute the query
			query.executeUpdate();

		// Return true for successful execution
		return true;
	}

}
