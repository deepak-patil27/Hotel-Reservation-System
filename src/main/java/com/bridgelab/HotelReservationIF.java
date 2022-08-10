package com.bridgelab;

import java.util.ArrayList;

public interface HotelReservationIF {
	
	public void addHotel(String hotelName,int rating, double weekDayRate,double weekendRate);
	public int getHotelListSize();
	public void printHotelList();
	public ArrayList<Hotel> getHotelList();
}
