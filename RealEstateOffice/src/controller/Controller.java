package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import model.Apartment;
import model.Office;

public class Controller {
	private Office theModel;

	public Controller(Office office) {
		this.theModel = office;
	}

	public String dublicateApt(int index) throws CloneNotSupportedException {
		return this.theModel.dublicateApt(index);
	}

	public String toString() {
		return this.theModel.toString();
	}

	public ArrayList<Apartment> getAllApartments() {
		return this.theModel.getAllApartments();
	}

	public boolean addApartment(Apartment a) {
		return this.theModel.addApartment(a);
	}

	public boolean isApartmentContains(Apartment apartment) {
		return this.theModel.isApartmentContains(apartment);
	}

	public String allApartmentsByType(String str) {
		return this.theModel.allApartmentsByType(str);

	}
	public void goToSelectedView(char c, Controller controller) {
		this.theModel.goToSelectedView(c, controller);
	}

	public String getAllCommissions(ArrayList<Apartment> allApartments) {
		return this.theModel.getAllCommissions(allApartments);
	}

	public Apartment getFirstHireApartment() {
		return this.theModel.getFirstHireApartment();
	}

	public Apartment ApartmentWithMostPrice(int time) {
		return this.theModel.ApartmentWithMostPrice(time);
	}

	public Apartment getApartmentFromInputIndex(int index) {
		return this.theModel.getApartmentFromInputIndex(index);
	}

	
	public Apartment allApartmentData(int type, String address, double area, int numOfRooms, int borkerRate,
			int hiringTime, double price) {

		return this.theModel.allApartmentData(type, address, area, numOfRooms, borkerRate, hiringTime, price);
	}

	public boolean chooseApartment(int index, String str) {
		return this.theModel.chooseApartment(index, str);
	}

	public String getPriceForHringTime(int index, int time) {
		return this.theModel.getPriceForHringTime(index, time);
	}

	public String sortClients(int index) {
		return this.theModel.sortClients(index);
	}

	public String getClients(int index) {
		return this.theModel.getClients(index);
	}

	public void saveAllApartmentToFile() throws FileNotFoundException, IOException {
		this.theModel.saveAllApartmentToFile();
	}

	public void readAllApartmentFromFile() throws FileNotFoundException, IOException, ClassNotFoundException {
		this.theModel.readAllApartmentFromFile();
	}

	public String helpPrint() {
		return this.theModel.helpPrint();
	}
}
