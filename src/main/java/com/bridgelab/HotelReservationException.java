package com.bridgelab;

public class HotelReservationException extends RuntimeException{
	
	enum ExceptionType{
		ENTERED_NULL, ENTERED_EMPTY;
	}
	
	ExceptionType type;

	public HotelReservationException(ExceptionType type, String message) {

		super(message);
		this.type = type;
		
	} 

}
