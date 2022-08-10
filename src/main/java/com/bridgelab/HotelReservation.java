package com.bridgelab;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class HotelReservation implements HotelReservationIF {

	ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
	Hotel hotel;

	public void addHotel(String hotelName, int rating, double weekdayRegularCustomerCost, double weekendRegularCustomerCost) {
		
		hotel = new Hotel();
		hotel.setHotelName(hotelName);
		hotel.setRating(rating);
		hotel.setWeekdayRegularCustomerCost(weekdayRegularCustomerCost);
		hotel.setWeekendRegularCustomerCost(weekendRegularCustomerCost);
		hotelList.add(hotel);		
	}
	
	public int getHotelListSize() {
		return hotelList.size();
	}
	
	public void printHotelList() {
		System.out.println(hotelList);
	}
	
	public ArrayList<Hotel> getHotelList(){
		return hotelList;
	}

	public String getCheapestHotel(LocalDate startDate, LocalDate endDate) {

		int numberOfDays = (int) ChronoUnit.DAYS.between(startDate, endDate);
        int weekends = 0;
        
		while (startDate.compareTo(endDate) != 0) {
            switch (DayOfWeek.of(startDate.get(ChronoField.DAY_OF_WEEK))) {
                case SATURDAY:
                    ++weekends;
                    break;
                case SUNDAY:
                    ++weekends;
                    break;
            }
            startDate = startDate.plusDays(1);
        }
		
		final int weekdaysNumber = numberOfDays - weekends;
		final int weekendsNumber = weekends;
		
		final double cheapestPrice = hotelList.stream()
				.mapToDouble(hotel -> ((hotel.getWeekendRegularCustomerCost()*weekendsNumber) + hotel.getWeekdayRegularCustomerCost()*weekdaysNumber))
				.min()
				.orElse(Double.MAX_VALUE);
		
		ArrayList<Hotel> cheapestHotel = hotelList.stream()
				.filter(hotel -> (hotel.getWeekendRegularCustomerCost()*weekendsNumber + hotel.getWeekdayRegularCustomerCost()*weekdaysNumber) == cheapestPrice)
				.collect(Collectors.toCollection(ArrayList::new));
		
        if (cheapestPrice != Double.MAX_VALUE) {
        	
        	System.out.println("Cheapest Hotel : \n" + cheapestHotel.get(0).getHotelName() + ", Total Rates: " + cheapestPrice);
        	return cheapestHotel.get(0).getHotelName();
        }
        return null;
	}

	
	


}
