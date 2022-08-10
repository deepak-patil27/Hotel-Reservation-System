package com.bridgelab;

import java.time.LocalDate;
import java.util.ArrayList;

public interface HotelReservationIF {

	public void addHotel(String hotelName,int rating, double weekdayRegularCustomerCost, double weekendRegularCustomerCost);
	public int getHotelListSize();
	public void printHotelList();
	public ArrayList<Hotel> getHotelList();
	public ArrayList<Hotel> getCheapestHotel(LocalDate startDate, LocalDate endDate);
	public Hotel getCheapestBestRatedHotel(LocalDate startDate, LocalDate endDate);

}
