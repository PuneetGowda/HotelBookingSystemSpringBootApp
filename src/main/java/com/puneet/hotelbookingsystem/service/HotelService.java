package com.puneet.hotelbookingsystem.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.puneet.hotelbookingsystem.dao.IHotelDAO;
import com.puneet.hotelbookingsystem.dto.BookingDTO;
import com.puneet.hotelbookingsystem.dto.CustomerDTO;
import com.puneet.hotelbookingsystem.dto.EmployeeDTO;
import com.puneet.hotelbookingsystem.dto.HotelDTO;
import com.puneet.hotelbookingsystem.dto.HotelInformationDTO;
import com.puneet.hotelbookingsystem.dto.RoomDTO;
import com.puneet.hotelbookingsystem.dto.ServiceDTO;
import com.puneet.hotelbookingsystem.entity.BookingStatus;
import com.puneet.hotelbookingsystem.entity.Hotel;
import com.puneet.hotelbookingsystem.exceptionhandler.HotelNotFoundException;

// This class 
@Service
public class HotelService implements IHotelService {

	private static Logger logger = LogManager.getLogger(HotelService.class);

	private IHotelDAO hotelDAO;

	// Inject hotel dao interface for calling its methods
	@Autowired
	public HotelService(IHotelDAO hotelDAO) {
		this.hotelDAO = hotelDAO;
	}

	public HotelService() {
	}

	// This method returns the list of hotels
	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
	public List<HotelDTO> getListOfHotels(String hotels) {

		// If hotel_name has value then keep the value else add empty string as value
		Optional<String> hotelsOptional = Optional.ofNullable(hotels);
		String hotel_name = hotelsOptional.isPresent() ? hotelsOptional.get() : "";

		// Get the list of hotel object array by calling getListOfHotels method of
		// hotelDAO
		List<Object[]> nativeQuery = hotelDAO.getListOfHotels(hotel_name);

		// Create List object of HotelDTO to return from Native query
		List<HotelDTO> hotelDTOListNative = new ArrayList<HotelDTO>();

		// Loop through all the hotel object, type cast into hotel dto fields and add
		// the hotel dto object to list of hotels
		nativeQuery.forEach(hotel -> {
			HotelDTO hotelDTO = new HotelDTO();
			hotelDTO.setHotel_id((int) hotel[0]);
			hotelDTO.setHotel_name((String) hotel[1]);
			hotelDTO.setHotel_location((String) hotel[2]);
			hotelDTO.setHotel_phone((String) hotel[3]);
			hotelDTO.setHotel_email((String) hotel[4]);
			hotelDTO.setHotel_rating((int) hotel[5]);
			hotelDTO.setPet_friendly((boolean) hotel[6]);

			hotelDTOListNative.add(hotelDTO);
		});

		// Delegate the call to hotel dao
		return hotelDTOListNative;
	}

	// This method return hotel information
	@Override
	@Cacheable(cacheNames = "hotels", key = "#hotel_id")
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
	public HotelInformationDTO getHotelInformation(int hotel_id) {

		// Create hotel information dto object to return
		HotelInformationDTO hotelDTO = new HotelInformationDTO();

		// Initialize Integer ArrayList for setting list properties of hotel dto
		List<Integer> customerIdList = new ArrayList<>();
		List<Integer> bookingIdList = new ArrayList<>();
		List<Integer> serviceIdList = new ArrayList<>();
		List<Integer> employeeIdList = new ArrayList<>();
		List<Integer> roomIdList = new ArrayList<>();

		// Call the dao method to get list of hotel information object
		List<Object[]> query = hotelDAO.getHotelInformation(hotel_id);

		if (query == null) {
			throw new HotelNotFoundException("Hotel not found with hotel id "+hotel_id);
		}
		
		logger.info("Testing the query " + query.get(0));

		// Get the first array of the list
		Object[] hotelArr = query.get(0);

		// Set the general hotel information
		hotelDTO.setHotel_id((int) hotelArr[0]);
		hotelDTO.setHotel_name((String) hotelArr[1]);
		hotelDTO.setHotel_location((String) hotelArr[2]);
		hotelDTO.setHotel_phone((String) hotelArr[3]);
		hotelDTO.setHotel_email((String) hotelArr[4]);
		hotelDTO.setHotel_rating((int) hotelArr[5]);
		hotelDTO.setPet_friendly((boolean) hotelArr[6]);

		// Loop through all the hotel objects, if id list doesn't contain that id then
		// add the id to the list
		query.forEach(obj -> {

			if (!customerIdList.contains((int) obj[11])) {
				logger.info("Called customer if statement");
				customerIdList.add((int) obj[11]);
			}

			if (!serviceIdList.contains((int) obj[10])) {
				logger.info("Called service if statement");
				serviceIdList.add((int) obj[10]);
			}

			if (!employeeIdList.contains((int) obj[9])) {
				employeeIdList.add((int) obj[9]);
			}

			if (!roomIdList.contains((int) obj[8])) {
				roomIdList.add((int) obj[8]);
			}

			if (!bookingIdList.contains((int) obj[7])) {
				bookingIdList.add((int) obj[7]);
			}

		});

		// Set the list properties of the Hotel DTO
		hotelDTO.setHotel_booking(bookingIdList);
		hotelDTO.setHotel_customer(customerIdList);
		hotelDTO.setHotel_employee(employeeIdList);
		hotelDTO.setHotel_room(roomIdList);
		hotelDTO.setHotel_service(serviceIdList);

		// Return the hotel dao
		return hotelDTO;
	}

	// This method returns list of customers of hotel
	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
	public List<CustomerDTO> getAllCustomersOfHotel(int hotel_id) {

		List<CustomerDTO> customerDTOList = new ArrayList<>();

		// Call the hotel dao method to get all customers of hotel list of object
		List<Object[]> queryResult = hotelDAO.getAllCustomersOfHotel(hotel_id);

		// Loop through all the object of queryResult
		queryResult.forEach(customer -> {
			CustomerDTO customerDTO = new CustomerDTO();

			customerDTO.setCustomer_id((int) customer[0]);
			customerDTO.setCustomer_name((String) customer[1]);
			customerDTO.setCustomer_address((String) customer[2]);
			customerDTO.setCustomer_phone((String) customer[3]);
			customerDTO.setCustomer_email((String) customer[4]);
			customerDTO.setCustomer_preferences((String) customer[5]);
			customerDTO.setCustomer_special_needs((String) customer[6]);

			customerDTOList.add(customerDTO);
		});

		return customerDTOList;
	}

	// This method returns list of all bookings of a hotel
	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
	public List<BookingDTO> getAllBookingsOfHotel(int hotel_id) {

		List<BookingDTO> bookingDTOList = new ArrayList<>();

		// Call the dao method to get all the bookings object of hotel
		List<Object[]> bookingListObject = hotelDAO.getAllBookingsOfHotel(hotel_id);

		bookingListObject.forEach(booking -> {
			;
			BookingDTO bookingDTO = new BookingDTO();

			bookingDTO.setBooking_id((int) booking[0]);
			bookingDTO.setBooking_date_time((Date) booking[1]);
			bookingDTO.setBooking_amount((double) booking[2]);
			bookingDTO.setCheck_in_date_time((Date) booking[3]);
			bookingDTO.setCheck_out_date_Time((Date) booking[4]);
			bookingDTO.setNo_of_adults((Integer) booking[5]);
			bookingDTO.setNo_of_child((Integer) booking[6]);
			bookingDTO.setBooking_status((BookingStatus) booking[7]);

			bookingDTOList.add(bookingDTO);
		});

		return bookingDTOList;
	}

	// This service method returns the list of all services of a hotel
	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
	public List<ServiceDTO> getAllServicesOfHotel(int hotel_id) {

		// Create array list of serviceDTO for returning
		List<ServiceDTO> serviceDTOList = new ArrayList<>();

		// Call the dao method to get services of hotel
		List<Object[]> serviceObjList = hotelDAO.getAllServicesOfHotel(hotel_id);

		logger.info("Inside service of hotel" + serviceObjList);

		// Loop through all the service array object of list, create ServiceDTO object,
		// set its properties and add it to serviceDTOList
		serviceObjList.forEach(service -> {
			logger.info("Service test " + Arrays.toString(service));
			ServiceDTO serviceDTO = new ServiceDTO();

			serviceDTO.setService_id((int) service[0]);
			serviceDTO.setService_name((String) service[1]);
			serviceDTO.setService_price((BigDecimal) service[2]);

			serviceDTOList.add(serviceDTO);
		});

		// Return the list of services
		return serviceDTOList;
	}

	// This service method return list of employees of a hotel
	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
	public List<EmployeeDTO> getAllEmployeesOfHotel(int hotel_id) {

		// Create employee dto list
		List<EmployeeDTO> employeeDTOList = new ArrayList<>();

		// Get the list of employee object
		List<Object[]> employeeObjList = hotelDAO.getAllEmployeesOfHotel(hotel_id);

		// Loop through list of employee object, set the properties of employeeDTO and
		// add it to the list of employee dto
		employeeObjList.forEach(employee -> {
			EmployeeDTO employeeDTO = new EmployeeDTO();

			employeeDTO.setEmployee_id((int) employee[0]);
			employeeDTO.setEmployee_name((String) employee[1]);
			employeeDTO.setEmployee_salary((float) employee[2]);
			employeeDTO.setEmployee_phone((long) employee[3]);
			employeeDTO.setEmployee_address((String) employee[4]);
			employeeDTO.setEmployee_email((String) employee[5]);
			employeeDTO.setEmployee_joining_date((Date) employee[6]);

			employeeDTOList.add(employeeDTO);
		});

		// Return list of employee
		return employeeDTOList;
	}

	// This service method return list of all the rooms of a hotel
	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
	public List<RoomDTO> getAllRoomsOfHotel(int hotel_id) {

		// Create array list of room dto
		List<RoomDTO> roomDTOList = new ArrayList<>();

		// Get all rooms of hotel
		List<Object[]> roomObjList = hotelDAO.getAllRoomsOfHotel(hotel_id);

		// Loop through list of room object array, create room dto object and set its
		// properties, and add it to room dto list
		roomObjList.forEach(room -> {
			RoomDTO roomDTO = new RoomDTO();

			roomDTO.setRoom_id((int) room[0]);
			roomDTO.setRoom_type((String) room[1]);
			roomDTO.setRoom_price((float) room[2]);
			roomDTO.setRoom_no((int) room[3]);
			roomDTO.setFloor_no((int) room[4]);
			roomDTO.setRoom_area((String) room[5]);
			roomDTO.setRoom_occupancy_details((String) room[6]);

			roomDTOList.add(roomDTO);
		});

		// Return list of rooms
		return roomDTOList;
	}

	// This service method calls dao method to add a new hotel and return boolean
	// value
	@Override
	@CacheEvict(cacheNames = "hotels", allEntries = true)
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
	public String addNewHotel(Hotel hotel) {

		// Delegate the call to hotel dao
		boolean addedHotel = hotelDAO.addNewHotel(hotel);

		return addedHotel == true ? "Hotel Added Successfully" : "Operation Unsuccessful";
	}

	// This service method calls the dao method to edit a hotel and return a booelan
	// value
	@Override
	@CachePut(cacheNames = "hotels", key = "#hotel_id")
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
	public boolean editHotel(int hotel_id, Hotel hotel) {

		// Delegate the call to hotel dao
		return hotelDAO.editHotel(hotel_id, hotel);
	}

	// This service method calls the dao method to delete a hotel and return a
	// boolean value
	@Override
	@CacheEvict(cacheNames = "hotels", key = "#hotel_id")
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
	public boolean deleteHotel(int hotel_id) {

		// Delegate the call to hotel dao
		return hotelDAO.deleteHotel(hotel_id);
	}

}
