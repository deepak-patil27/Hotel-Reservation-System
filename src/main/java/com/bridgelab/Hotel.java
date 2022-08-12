package com.bridgelab;

public class Hotel {
	private String hotelName;
	private int rating;
	private double weekdayRegularCustomerCost;
	private double weekendRegularCustomerCost;
	private double weekdayRewardCustomerCost;
	private double weekendRewardCustomerCost;

	public Hotel() {
	}

	public Hotel(String hotelName, int rating, double weekdayRegularCustomerCost, double weekendRegularCustomerCost,
			double weekdayRewardCustomerCost, double weekendRewardCustomerCost) {
		this.hotelName = hotelName;
		this.rating = rating;
		this.weekdayRegularCustomerCost = weekdayRegularCustomerCost;
		this.weekendRegularCustomerCost = weekendRegularCustomerCost;
		this.weekdayRewardCustomerCost = weekdayRewardCustomerCost;
		this.weekendRewardCustomerCost = weekendRewardCustomerCost;
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

	public double getWeekdayRegularCustomerCost() {
		return weekdayRegularCustomerCost;
	}

	public void setWeekdayRegularCustomerCost(double weekdayRegularCustomerCost) {
		this.weekdayRegularCustomerCost = weekdayRegularCustomerCost;
	}

	public double getWeekendRegularCustomerCost() {
		return weekendRegularCustomerCost;
	}

	public void setWeekendRegularCustomerCost(double weekendRegularCustomerCost) {
		this.weekendRegularCustomerCost = weekendRegularCustomerCost;
	}

	public double getWeekdayRewardCustomerCost() {
		return weekdayRewardCustomerCost;
	}

	public void setWeekdayRewardCustomerCost(double weekdayRewardCustomerCost) {
		this.weekdayRewardCustomerCost = weekdayRewardCustomerCost;
	}

	public double getWeekendRewardCustomerCost() {
		return weekendRewardCustomerCost;
	}

	public void setWeekendRewardCustomerCost(double weekendRewardCustomerCost) {
		this.weekendRewardCustomerCost = weekendRewardCustomerCost;
	}

	@Override
	public String toString() {
		return "Hotels [hotelName=" + hotelName + ", rating=" + rating + ", Regular Customer WeekDay Cost="
				+ weekdayRegularCustomerCost + "Regular Customer WeekDay Cost=" + weekdayRegularCustomerCost + ", Reward Customer WeekDay Cost="
				+ weekdayRewardCustomerCost + "Reward Customer WeekDay Cost=" + weekendRewardCustomerCost + "]\n";
	}

}
