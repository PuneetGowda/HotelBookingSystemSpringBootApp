package com.puneet.hotelbookingsystem.dao;

import java.util.List;

import com.puneet.hotelbookingsystem.entity.Hotel;

public interface IHotelDAO {

	List<Object[]> getListOfHotels(String hotel_name);

	List<Object[]> getHotelInformation(int hotel_id);

	List<Object[]> getAllCustomersOfHotel(int hotel_id);

	List<Object[]> getAllBookingsOfHotel(int hotel_id);

	List<Object[]> getAllServicesOfHotel(int hotel_id);

	List<Object[]> getAllEmployeesOfHotel(int hotel_id);

	List<Object[]> getAllRoomsOfHotel(int hotel_id);

	boolean addNewHotel(Hotel hotel);

	boolean editHotel(int hotel_id, Hotel hotel);

	boolean deleteHotel(int hotel_id);

}
