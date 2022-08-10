package com.bridgelab;

import java.time.LocalDate;
import java.util.ArrayList;

public interface HotelReservationIF {
	
	public void addHotel(String hotelName,int rating, double weekdayRegularCustomerCost, double weekendRegularCustomerCost);
	public int getHotelListSize();
	public void printHotelList();
	public ArrayList<Hotel> getHotelList();
	public String getCheapestHotel(LocalDate startDate, LocalDate endDate);
	
}
