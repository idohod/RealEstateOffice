package model;

import exceptions.ApartmentPriceException;

public class RegularApartment extends HireApartment implements Icommission {
	private double pricePerMonth;

	public RegularApartment(String address, double area, int numOfRooms, int brokerRate, int hiringTime,
			double pricePerMonth) throws Exception {
		super(address, area, numOfRooms, brokerRate, hiringTime);
		setPricePerMonth(pricePerMonth);
	}

	@Override
	public double getPriceForHiringTime(int time) {
		return Commission() + (this.pricePerMonth * time);
	}

	public double getPricePerMonth() {
		return pricePerMonth;
	}

	public void setPricePerMonth(double pricePerMonth) {
		if (pricePerMonth <= 0)
			throw new ApartmentPriceException("price must be positive numner");
		this.pricePerMonth = pricePerMonth;
	}

	@Override
	public String toString() {

		return super.toString() + " pricePerMonth = " + pricePerMonth + "\n";
	}

	@Override
	public double Commission() {
		return 4000.0;
	}

}
