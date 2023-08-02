package model;

import exceptions.ApartmentPriceException;

public class SellApartment extends Apartment implements Icommission {
	private double price;

	public SellApartment(String address, double area, int numOfRooms, int brokerRate, double price) throws Exception {
		super(address, area, numOfRooms, brokerRate);
		setPrice(price);
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price <= 0)
			throw new ApartmentPriceException("price must be positive numner");
		this.price = price;
	}

	@Override
	public String toString() {
		return super.toString() + " price = " + price + "\n";
	}

	@Override
	public double Commission() {
		double tempPrice = price;
		return tempPrice *= 0.05;
	}

}
