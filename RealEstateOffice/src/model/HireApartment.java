package model;

import exceptions.ApartmentHiringTimeException;

public abstract class HireApartment extends Apartment {
	protected int hiringTime;

	public HireApartment(String address, double area, int numOfRooms, int brokerRate, int hiringTime) throws Exception {
		super(address, area, numOfRooms, brokerRate);

		setHiringTime(hiringTime);
	}

	public abstract double getPriceForHiringTime(int time);

	public int getHiringTime() {
		return hiringTime;
	}

	public void setHiringTime(int hiringTime) {
		if (hiringTime <= 0)
			throw new ApartmentHiringTimeException("hiring time must be positive number");
		this.hiringTime = hiringTime;
	}

	@Override
	public String toString() {
		return super.toString() + " hiringTime = " + hiringTime + "\n";
	}

	

}
