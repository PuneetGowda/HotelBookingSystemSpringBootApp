package com.puneet.hotelbookingsystem.exceptionhandler;

public class HotelNotFoundException extends RuntimeException {

		public HotelNotFoundException() {}
		
		public HotelNotFoundException(String message) {
			super(message);
		}
		
		public HotelNotFoundException(Throwable cause) {
			super(cause);
		}
		
		public HotelNotFoundException(String message, Throwable cause) {
			super(message, cause);
		}
}
