package com.bridgelab;

public class Hotel {
	String hotelName;
	int rating;
	double weekdayRegularCustomerCost;
	double weekendRegularCustomerCost;

	public Hotel() {

	}

	public Hotel(String hotelName, int rating, double weekdayRegularCustomerCost, double weekdayRewardCustomerCost,
			double weekendRegularCustomerCost, double weekendRewardCustomerCost) {
		this.hotelName = hotelName;
		this.rating = rating;
		this.weekdayRegularCustomerCost = weekdayRegularCustomerCost;
		this.weekendRegularCustomerCost = weekendRegularCustomerCost;
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

	public double getWeekdayRegularCustomerPrice() {
		return weekdayRegularCustomerCost;
	}

	public void setWeekdayRegularCustomerPrice(double weekdayRegularCustomerCost) {
		this.weekdayRegularCustomerCost = weekdayRegularCustomerCost;
	}

	public double getWeekendRegularCustomerPrice() {
		return weekendRegularCustomerCost;
	}

	public void setWeekendRegularCustomerPrice(double weekendRegularCustomerCost) {
		this.weekendRegularCustomerCost = weekendRegularCustomerCost;
	}

	@Override
	public String toString() {
		return "Hotel [hotelName=" + hotelName + ", rating=" + rating + ", weekdayRegularCustomerCost="
				+ weekdayRegularCustomerCost + ", weekendRegularCustomerCost=" + weekendRegularCustomerCost + "]";
	}

}
