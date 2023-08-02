package model;

import exceptions.ApartmentPriceException;

public class AirbnbApartment extends HireApartment {
	private double pricePerDay;

	public AirbnbApartment(String address, double area, int numOfRooms, int brokerRate, int hiringTime,
			double pricePerDay) throws Exception {
		super(address, area, numOfRooms, brokerRate, hiringTime);
		setPricePerDay(pricePerDay);
	}

	@Override
	public double getPriceForHiringTime(int time) {
		return this.pricePerDay * time;
	}

	public double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(double pricePerDay) {
		if (pricePerDay <= 0)
			throw new ApartmentPriceException("price must be positive numner");
		this.pricePerDay = pricePerDay;
	}

	@Override
	public String toString() {

		return super.toString() + " pricePerDay = " + pricePerDay + "\n";
	}

	}
