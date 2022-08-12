package com.bridgelab;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest {

	@Test
	public void givenHotelDetails_WhenValuesEnteredAreCorrect_ShoulReturnTrue() {
		HotelReservationIF hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 3, 110, 90, 80, 80);
		hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);
		hotelReservation.addHotel("Ridgewood", 5, 220, 150, 100, 40);
		int hotelListSize = hotelReservation.getHotelListSize();
		hotelReservation.printHotelList();
		Assert.assertEquals(3, hotelListSize);
	}

	@Test
	public void givenHotelList_WhenAdded_shouldReturnProperHotelName() {
		HotelReservationIF hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);
		String hotelName = hotelReservation.getHotelList().get(0).getHotelName();
		Assert.assertEquals("Bridgewood", hotelName);
	}

	@Test
	public void givenHotelList_WhenAdded_shouldReturnProperHotelRating() {
		HotelReservationIF hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Ridgewood", 5, 220, 150, 100, 40);
		int hotelRating = hotelReservation.getHotelList().get(0).getRating();
		Assert.assertEquals(5, hotelRating);
	}

	@Test
	public void givenHotelList_WhenAdded_shouldReturnProperHotelWeekdayRegularCustomerCost() {
		HotelReservationIF hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);
		int hotelRegularCustomerCost = (int) hotelReservation.getHotelList().get(0).getWeekdayRegularCustomerCost();
		Assert.assertEquals(150, hotelRegularCustomerCost);
	}

	@Test
	public void givenHotelList_WhenAdded_shouldReturnProperHotelWeekendRegularCustomerCost() {
		HotelReservationIF hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);
		int hotelRegularCustomerCost = (int) hotelReservation.getHotelList().get(0).getWeekendRegularCustomerCost();
		Assert.assertEquals(50, hotelRegularCustomerCost);
	}

	@Test
	public void givenHotelList_WhenAdded_shouldReturnProperHotelWeekdayRewardCustomerCost() {
		HotelReservationIF hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);
		int hotelRewardCustomerCost = (int) hotelReservation.getHotelList().get(0).getWeekdayRewardCustomerCost();
		hotelReservation.printHotelList();
		Assert.assertEquals(110, hotelRewardCustomerCost);
	}

	@Test
	public void givenHotelList_WhenAdded_shouldReturnProperHotelWeekendRewardCustomerCost() {
		HotelReservationIF hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);
		int hotelRegularCustomerCost = (int) hotelReservation.getHotelList().get(0).getWeekendRewardCustomerCost();
		hotelReservation.printHotelList();
		Assert.assertEquals(50, hotelRegularCustomerCost);
	}

	@Test
	public void givenHotelDetails_shouldReturnCheapestHotel() {

		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 3, 110, 90, 80, 80);
		hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);
		LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 11);
		LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 12);
		ArrayList<Hotel> hotel = hotelReservation.getCheapestHotel(startDate, endDate);
		String hotelName = hotel.get(0).getHotelName() + " " + hotel.get(1).getHotelName();
		Assert.assertEquals("Lakewood Bridgewood", hotelName);
	}

	@Test
	public void givenHotelDetails_WhenHotelPricesAreSame_shouldReturnHighestRatedHotel() {

		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 3, 110, 90, 80, 80);
		hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);
		LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 11);
		LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 12);
		Hotel hotel = hotelReservation.getCheapestBestRatedHotel(startDate, endDate);
		Assert.assertEquals("Bridgewood", hotel.getHotelName());
	}

	@Test
	public void givenHotelDetails_shouldReturnHighestRatedHotel() {

		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 3, 110, 90, 80, 80);
		hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);
		hotelReservation.addHotel("Ridgewood", 5, 220, 150, 100, 40);
		LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 11);
		LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 12);
		Hotel hotel = hotelReservation.getBestRatedHotel(startDate, endDate);
		Assert.assertEquals("Ridgewood", hotel.getHotelName());
	}
}
