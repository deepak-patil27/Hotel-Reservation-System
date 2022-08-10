package com.bridgelab;

public class Hotel {
	private String hotelName;
	private int rating;
	private double weekDayRate;
	private double weekendRate;
	public Hotel() {
	}

	public Hotel(String hotelName, int rating, double weekDayRate, double weekendRate) {
		this.hotelName = hotelName;
		this.rating = rating;
		this.weekDayRate = weekDayRate;
		this.weekendRate=weekendRate;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public double getWeekDayRate() {
		return weekDayRate;
	}

	public void setWeekDayRate(double weekDayRate) {
		this.weekDayRate = weekDayRate;
	}

	public double getWeekendRate() {
		return weekendRate;
	}

	public void setWeekendRate(double weekendRate) {
		this.weekendRate = weekendRate;
	}

	@Override
	public String toString() {
		return "Hotel [hotelName=" + hotelName + ", rating=" + rating + ", weekDayRate=" + weekDayRate
				+ ", weekendRate=" + weekendRate + "]";
	}



}
