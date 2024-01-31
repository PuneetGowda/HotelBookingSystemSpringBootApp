package com.puneet.hotelbookingsystem.observer;

import com.puneet.hotelbookingsystem.entity.Booking;

// Abstract observer
public interface BookingObserver {

	void updated(Booking booking);
}
