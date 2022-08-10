package com.bridgelab;

public class Hotel {
	private String hotelName;
	private int rating;
	private double regularCustomerCost;

	public Hotel() {
	}

	public Hotel(String hotelName, int rating, double regularCustomerCost) {
		this.hotelName = hotelName;
		this.rating = rating;
		this.regularCustomerCost = regularCustomerCost;
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
	
	public double getRegularCustomerCost() {
		return regularCustomerCost;
	}
	
	public void setRegularCustomerCost(double regularCustomerCost) {
		this.regularCustomerCost = regularCustomerCost;
	}
	
	@Override
	public String toString() {
		return "Hotels [hotelName=" + hotelName + ", rating=" + rating + ", Regular Customer Cost="+ regularCustomerCost +"]\n";
	}


}
