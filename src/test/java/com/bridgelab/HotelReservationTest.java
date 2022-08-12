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
	public void givenHotelDetails_WhenRegularCustomer_shouldReturnCheapestHotel() {

		HotelReservationIF hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 3, 110, 90, 80, 80);
		hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);

		LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 11);
		LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 12);
		String startDateToValidate = startDate.toString();
		String endDateToValidate = endDate.toString();
		boolean isValidStartDate = hotelReservation.validateDate(startDateToValidate);
		boolean isValidEndDate = hotelReservation.validateDate(endDateToValidate);

		if (isValidStartDate && isValidEndDate) {
			ArrayList<Hotel> hotel = hotelReservation.getCheapestHotel("regular", startDate, endDate);
			String hotelName = hotel.get(0).getHotelName() + " " + hotel.get(1).getHotelName();
			Assert.assertEquals("Lakewood Bridgewood", hotelName);
		} else {
			System.out.println("Not Valid Start Or End date");
		}
	}

	@Test
	public void givenHotelDetails_WhenRegularCustomerAndHotelPricesAreSame_shouldReturnHighestRatedHotel() {

		HotelReservationIF hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 3, 110, 90, 80, 80);
		hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);

		LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 11);
		LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 12);
		String startDateToValidate = startDate.toString();
		String endDateToValidate = endDate.toString();
		boolean isValidStartDate = hotelReservation.validateDate(startDateToValidate);
		boolean isValidEndDate = hotelReservation.validateDate(endDateToValidate);

		if (isValidStartDate && isValidEndDate) {
			Hotel hotel = hotelReservation.getCheapestBestRatedHotel("regular", startDate, endDate);
			Assert.assertEquals("Bridgewood", hotel.getHotelName());
		} else {
			System.out.println("Not Valid Start Or End date");
		}
	}

	@Test
	public void givenHotelDetails_WhenRegularCustomer_ShouldReturnHighestRatedHotel() {

		HotelReservationIF hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 3, 110, 90, 80, 80);
		hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);
		hotelReservation.addHotel("Ridgewood", 5, 220, 150, 100, 40);

		LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 11);
		LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 12);
		String startDateToValidate = startDate.toString();
		String endDateToValidate = endDate.toString();
		boolean isValidStartDate = hotelReservation.validateDate(startDateToValidate);
		boolean isValidEndDate = hotelReservation.validateDate(endDateToValidate);

		if (isValidStartDate && isValidEndDate) {
			Hotel hotel = hotelReservation.getBestRatedHotel("regular", startDate, endDate);
			Assert.assertEquals("Ridgewood", hotel.getHotelName());
		} else {
			System.out.println("Not Valid Start Or End date");
		}
	}

	@Test
	public void givenHotelDetails_WhenRewardCustomer_ShouldReturnCheapestHotel() {

		HotelReservationIF hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 3, 110, 90, 80, 80);
		hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);
		LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 11);
		LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 12);
		ArrayList<Hotel> hotel = hotelReservation.getCheapestHotel("reward", startDate, endDate);
		String hotelName = hotel.get(0).getHotelName() + " " + hotel.get(1).getHotelName();
		Assert.assertEquals("Lakewood Bridgewood", hotelName);
	}

	@Test
	public void givenHotelDetails_WhenRewardCustomerAndHotelPricesAreSame_ShouldReturnHighestRatedHotel() {

		HotelReservationIF hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 3, 110, 90, 80, 80);
		hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);
		LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 11);
		LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 12);
		Hotel hotel = hotelReservation.getCheapestBestRatedHotel("reward", startDate, endDate);
		Assert.assertEquals("Bridgewood", hotel.getHotelName());
	}

	@Test
	public void givenHotelDetails_WhenRewardCustomer_ShouldReturnHighestRatedHotel() {

		HotelReservationIF hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 3, 110, 90, 80, 80);
		hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);
		hotelReservation.addHotel("Ridgewood", 5, 220, 150, 100, 40);
		LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 11);
		LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 12);
		Hotel hotel = hotelReservation.getBestRatedHotel("reward", startDate, endDate);
		Assert.assertEquals("Ridgewood", hotel.getHotelName());
	}

	@Test
	public void givenHotelDetails_WhenNull_ShouldThrowHotelReservationException() {

		try {
			HotelReservation hotelReservation = new HotelReservation();
			hotelReservation.addHotel("Lakewood", 3, 110, 90, 80, 80);
			hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);
			hotelReservation.addHotel("Ridgewood", 5, 220, 150, 100, 40);
			LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 11);
			LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 12);
			hotelReservation.getCheapestBestRatedHotel(null, startDate, endDate);
		} catch (HotelReservationException e) {
			Assert.assertEquals(HotelReservationException.ExceptionType.ENTERED_NULL, e.type);
			e.printStackTrace();
		}

	}

	@Test
	public void givenHotelDetails_WhenEmpty_ShouldThrowHotelReservationException() {

		try {
			HotelReservation hotelReservation = new HotelReservation();
			hotelReservation.addHotel("Lakewood", 3, 110, 90, 80, 80);
			hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);
			hotelReservation.addHotel("Ridgewood", 5, 220, 150, 100, 40);
			LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 11);
			LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 12);
			hotelReservation.getCheapestBestRatedHotel("", startDate, endDate);
		} catch (HotelReservationException e) {
			Assert.assertEquals(HotelReservationException.ExceptionType.ENTERED_EMPTY, e.type);
			e.printStackTrace();
		}

	}

	@Test
	public void givenDate_WhenProper_ShouldReturnTrue() {

		HotelReservation hotelReservation = new HotelReservation();
		boolean isVAlid = hotelReservation.validateDate("2009-12-13");
		Assert.assertTrue(isVAlid);
	}

	@Test
	public void givenDate_WhenNotProperFormat_ShouldReturnFalse() {

		HotelReservation hotelReservation = new HotelReservation();
		boolean isNotVAlid = hotelReservation.validateDate("19-10-1999");
		Assert.assertFalse(isNotVAlid);
	}

	@Test
	public void givenDate_WhenSeperatedBySlashes_ShouldReturnFalse() {

		HotelReservation hotelReservation = new HotelReservation();
		boolean isNotVAlid = hotelReservation.validateDate("1999/09/2021");
		Assert.assertFalse(isNotVAlid);
	}

	@Test
	public void givenDate_WhenContainsCharcters_ShouldReturnFalse() {

		HotelReservation hotelReservation = new HotelReservation();
		boolean isNotVAlid = hotelReservation.validateDate("200s-a2-19");
		Assert.assertFalse(isNotVAlid);
	}

	@Test
	public void givenDate_WhenSpecialCharcters_ShouldReturnFalse() {

		HotelReservation hotelReservation = new HotelReservation();
		boolean isNotVAlid = hotelReservation.validateDate("2009/%%/13");
		Assert.assertFalse(isNotVAlid);
	}

	@Test
	public void givenDate_WhenNull_ShouldThrowHotelReservationException() {

		HotelReservation hotelReservation = new HotelReservation();
		try {
			String date = null;
			hotelReservation.validateDate(date);
		} catch (HotelReservationException e) {
			Assert.assertEquals(HotelReservationException.ExceptionType.ENTERED_NULL, e.type);
			e.printStackTrace();
		}
	}

	@Test
	public void givenDate_WhenEmpty_ShouldThrowHotelReservationException() {

		HotelReservation hotelReservation = new HotelReservation();
		try {
			String date = "";
			hotelReservation.validateDate(date);
		} catch (HotelReservationException e) {
			Assert.assertEquals(HotelReservationException.ExceptionType.ENTERED_EMPTY, e.type);
			e.printStackTrace();
		}
	}
}
