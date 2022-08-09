package com.bridgelab;

import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest {

	@Test
	public void givenHotelDetails_WhenValuesEnteredAreCorrect_ShoulReturnTrue() {
		HotelReservation hotelReservationService = new HotelReservation();
		boolean isValidHotel1 = hotelReservationService.addHotel("Lakewood", 3, 110, 90);
		Assert.assertTrue(isValidHotel1);
		boolean isValidHotel2 = hotelReservationService.addHotel("Bridgewood", 4, 16, 60);
		Assert.assertTrue(isValidHotel2);
		boolean isValidHotel3 = hotelReservationService.addHotel("Ridgewood", 5, 220, 150);
		Assert.assertTrue(isValidHotel3);
	}

}
