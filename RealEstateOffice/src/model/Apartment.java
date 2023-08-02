package model;

import java.io.Serializable;
import java.util.ArrayList;

import exceptions.ApartmentAddressException;
import exceptions.ApartmentAreaException;
import exceptions.ApartmentBorkerRateException;
import exceptions.ApartmentException;
import exceptions.ApartmentNumberOfRoomsException;

public abstract class Apartment implements Cloneable, Serializable {

	public static int idcounter = 1000;
	protected int idNumber;
	protected String address;
	protected double area;
	protected int numOfRooms;
	protected int brokerRate;
	protected ArrayList<Client> allClients;

	public Apartment(String address, double area, int numOfRooms, int brokerRate) throws ApartmentException {
		this.allClients = new ArrayList<>();
		this.idNumber = idcounter++;
		setAddress(address);
		setArea(area);
		setNumOfRooms(numOfRooms);
		setBrokerRate(brokerRate);

	}
	public Client allClientData(String name, String phone ) {
		if(name.equals("")||phone.equals("")|| name == null || phone == null ) 
			return null;
		Client c = new Client(name,phone);
		return c;
	}

	@Override
	public Apartment clone() throws CloneNotSupportedException {
		Apartment temp = (Apartment) super.clone();
		temp.allClients = (ArrayList<Client>) allClients.clone();
		return temp;
	}

	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}

	public void swap(Client[] arr, int i, int j) {
		Client temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public void sort(Client[] arr) {

		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j].getName().compareTo(arr[j + 1].getName()) > 0) {
					swap(arr, j, j + 1);
				}
			}
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Apartment other = (Apartment) obj;
		if (this.address == null)
			return other.address == null;
		return this.address.equals(other.address);
	}

	public boolean addClient(Client client) {
		if (allClients.contains(client))
			return false;

		allClients.add(client);
		return true;
	}

	public ArrayList<Client> getAllClients() {
		return allClients;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if (address == null || address.equals(""))
			throw new ApartmentAddressException("you didn't enter address");
		this.address = address;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		if (area <= 0)
			throw new ApartmentAreaException("area must be positive number");
		this.area = area;
	}

	public int getNumOfRooms() {
		return numOfRooms;
	}

	public void setNumOfRooms(int numOfRooms) {
		if (numOfRooms <= 0)
			throw new ApartmentNumberOfRoomsException("number of rooms must be positive integer");
		this.numOfRooms = numOfRooms;

	}

	public int getBrokerRate() {
		return brokerRate;
	}

	public void setBrokerRate(int brokerRate) throws ApartmentException {
		if (brokerRate < 0 || brokerRate > 10) {
			throw new ApartmentBorkerRateException("brokerRate must be integer between 0 to 10");
		} else {
			this.brokerRate = brokerRate;
		}
	}

	public int getIdNumber() {
		return idNumber;
	}

	public String getClientsByApartment() {

		StringBuilder sb = new StringBuilder();
		sb.append("the clients for this " + getClass().getSimpleName() + " are:\n");
		for (Client client : allClients) {
			if (this.allClients.contains(client)) {
				sb.append(client.toString() + "\n");
			}
		}
		return sb.toString();

	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ":\n" + " idNumber = " + idNumber + ", address = " + address + ", area = "
				+ area + ", numOfRooms = " + numOfRooms + ", brokerRate = " + brokerRate ;

	}

}
