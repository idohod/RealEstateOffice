package model;

import java.io.*;
import java.util.ArrayList;
import controller.Controller;
import exceptions.ApartmentAddressException;
import exceptions.ApartmentAreaException;
import exceptions.ApartmentBorkerRateException;
import exceptions.ApartmentException;
import exceptions.ApartmentHiringTimeException;
import exceptions.ApartmentNumberOfRoomsException;
import exceptions.ApartmentPriceException;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.AddApartmentView;
import view.AddClientView;
import view.AllApartmentsByTypeView;
import view.AllApartmentsView;
import view.AllClientsView;
import view.ApartmentWithMostPriceView;
import view.CloneAptView;
import view.CommtionView;
import view.MessegeView;
import view.PriceForHringTimeView;
import view.View;

public class Office implements iMangment {

	private ArrayList<Apartment> allApartments;

	public Office() {
		allApartments = new ArrayList<>(0);
	}

	public ArrayList<Apartment> getAllApartments() {
		return allApartments;
	}

	public boolean isApartmentContains(Apartment apartment) {
		return this.allApartments.contains(apartment);
	}

	public boolean addApartment(Apartment apartment) {
		if (allApartments.contains(apartment))
			return false;

		allApartments.add(apartment);
		return true;
	}

	public Apartment getFirstHireApartment() {
		int index = 0;

		while (index < allApartments.size()) {
			if (allApartments.get(index) instanceof HireApartment) {
				Apartment temp = allApartments.get(index);
				return temp;
			} else
				index++;
		}
		return null;

	}

	public Apartment ApartmentWithMostPrice(int time) {
		int index;
		if (allApartments.size() == 0)
			return null;

		Apartment temp = getFirstHireApartment();
		if (temp == null) {
			return null;
		}
		index = allApartments.indexOf(temp);

		for (int i = (index + 1); i < allApartments.size(); i++) {
			if (allApartments.get(i) instanceof HireApartment) {
				if (((HireApartment) allApartments.get(i)).getPriceForHiringTime(time) > ((HireApartment) temp)
						.getPriceForHiringTime(time))
					temp = allApartments.get(i);
			}
		}
		return temp;
	}

	public String allApartmentsByType(String str) {
		StringBuffer sb = new StringBuffer();
		for (Apartment a : allApartments) {
			if (a.getClass().getSimpleName().equals(str)) {
				sb.append(a.toString() + "\n");
			} else {
				sb.append("");
			}
		}

		return sb.toString().equals("") ? "you did not added any apartment from this type" : sb.toString();
	}

	public String getClients(int index) {
		Apartment apt = this.getApartmentFromInputIndex(index);

		if (this.isApartmentContains(apt)) {
			int index1 = this.getAllApartments().indexOf(apt);
			return this.getAllApartments().get(index1).getClientsByApartment();
		} else
			return "not apatment exists";

	}

	public String sortClients(int index) {

		StringBuffer sb = new StringBuffer();

		Client[] namesToSort = (Client[]) this.getAllApartments().get(index - 1).getAllClients().toArray(new Client[0]);

		this.getAllApartments().get(index - 1).sort(namesToSort);

		for (int i = 0; i < namesToSort.length; i++) {
			sb.append(namesToSort[i].getName() + "\n");
		}
		return sb.toString();

	}

	public String getPriceForHringTime(int index, int time) {

		Apartment tempApt = this.getApartmentFromInputIndex(index);

		if (!this.isApartmentContains(tempApt)) {
			return "apartment dont exiest";

		}
		if (tempApt instanceof HireApartment) {
			HireApartment ha = (HireApartment) (tempApt);
			return "the price is: " + ha.getPriceForHiringTime(time);
		} else {
			return "this apartment not to hire";
		}

	}

	public String getAllCommissions(ArrayList<Apartment> allApartments) {

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < allApartments.size(); i++) {
			if (allApartments.get(i) instanceof Icommission) {
				Icommission c = (Icommission) (allApartments.get(i));
				sb.append("apatmrnt type: " + allApartments.get(i).getClass().getSimpleName() + ", id: "
						+ allApartments.get(i).idNumber + ", Commission: " + c.Commission() + "\n\n");
			}
			
		}

		return sb.toString().equals("")
				? "you did not added any apartment\n or\nyou added only airbnb apartments that dont have commission"
				: sb.toString();
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		if (allApartments.size() == 0) {
			return "\ndont have any aprtment yet";
		}

		for (Apartment a : allApartments) {
			sb.append(a.toString() + "\n");
		}

		return sb.toString();
	}

	public Apartment getApartmentFromInputIndex(int index) {
		boolean flag = true;
		do {
			try {
				if (index > allApartments.size()) {
					throw new ApartmentException("number must be between 1 to " + allApartments.size());
				} else {
					flag = false;
				}
			} catch (NumberFormatException e) {
				new MessegeView("worng input. you must enter integer");
			} catch (ApartmentException e) {
				new MessegeView(e.getMessage());

			}
		} while (flag);
		return this.allApartments.get(index - 1);

	}

	public String helpPrint() {
		String str = "1 - add apartment to the office\n2 - add client to apartment\n3 - show all apartments\n"
				+ "4 - show all apartments by type\n5 - price for hire apartment\n6 - the most expensive apartment for hiring time\n"
				+ "7 - show all clients for apartment and sort the names\n"
				+ "8 - show commission for all apartments\n9 - dublicate apartment\n0 - save to binery file and quit ";
		return str;
	}

	public void saveAllApartmentToFile() throws FileNotFoundException, IOException {
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
		ArrayList<Apartment> a = this.allApartments;
		int n = a.size();
		o.writeInt(n);
		for (int i = 0; i < a.size(); i++) {
			o.writeObject(allApartments.get(i));
		}
		o.close();
	}

	public void readAllApartmentFromFile() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME));
		int n = in.readInt();

		for (int j = 0; j < n; j++) {
			Apartment a = (Apartment) in.readObject();
			addApartment(a);

		}

		in.close();

	}

	private void add4Clients(Apartment a) {

		Client c1 = new Client("Ido Hod", "050-5205066");
		Client c2 = new Client("Ben Levi", "052-11223344");
		Client c3 = new Client("Ziv Levin", "050-6601011");
		Client c4 = new Client("Ariel Amsalem", "052-3332022");

		Client[] allClient = { c1, c2, c3, c4 };

		for (Client c : allClient) {
			a.addClient(c);

		}

	}

	public String dublicateApt(int index) throws CloneNotSupportedException {

		Apartment a = this.getApartmentFromInputIndex(index);

		Apartment nApartment = a.clone();
		return nApartment + "\n" + nApartment.getClientsByApartment();

	}

	public Apartment allApartmentData(int type, String address, double area, int numOfRooms, int borkerRate,
			int hiringTime, double price) {

		try {
			if (type == 1) {
				AirbnbApartment airbnb = new AirbnbApartment(address, area, numOfRooms, borkerRate, hiringTime, price);
				airbnb.setIdNumber(1000 + this.getAllApartments().size());
				add4Clients(airbnb);
				return airbnb;

			} else if (type == 2) {
				RegularApartment reg = new RegularApartment(address, area, numOfRooms, borkerRate, hiringTime, price);
				reg.setIdNumber(1000 + this.getAllApartments().size());
				add4Clients(reg);
				return reg;

			} else if (type == 3) {
				SellApartment sell = new SellApartment(address, area, numOfRooms, borkerRate, price);
				sell.setIdNumber(1000 + this.getAllApartments().size());
				add4Clients(sell);
				return sell;
			}

		} catch (NumberFormatException ne) {
			new MessegeView("you must enter a number");

		} catch (ApartmentAddressException e) {
			new MessegeView(e.getMessage());
			return null;

		} catch (ApartmentAreaException e1) {
			new MessegeView(e1.getMessage());
			return null;

		} catch (ApartmentNumberOfRoomsException e2) {
			new MessegeView(e2.getMessage());
			return null;

		} catch (ApartmentBorkerRateException e3) {
			new MessegeView(e3.getMessage());
			return null;

		} catch (ApartmentHiringTimeException e4) {
			new MessegeView(e4.getMessage());
			return null;

		} catch (ApartmentPriceException e6) {
			new MessegeView(e6.getMessage());
			return null;

		} catch (Exception e7) {
			new MessegeView(e7.getMessage());
			return null;

		}

		return null;
	}

	

	public boolean chooseApartment(int index, String str) {

		try {
			index = Integer.parseInt(str);

			if (index > this.getAllApartments().size()) {
				new MessegeView(
						"wrong input!\n the number you entered higher then \n the number of apatments that exists in the office");
				return false;
			}
			return this.isApartmentContains(this.getApartmentFromInputIndex(index));

		} catch (NumberFormatException e) {
			new MessegeView("you must enter an integer!");
			return false;

		}
	}

	public void goToSelectedView(char c, Controller controller) {

		if (c == '1') {

			View view = new AddApartmentView(controller);
			crateStage((AddApartmentView) view, 600, 400);

		} else if (c == '2') {

			View view = new AddClientView(controller);
			crateStage((AddClientView) view, 430, 280);

		} else if (c == '3') {

			View view = new AllApartmentsView(controller);
			crateStage((AllApartmentsView) view, 700, 700);

		} else if (c == '4') {

			View view = new AllApartmentsByTypeView(controller);
			crateStage((AllApartmentsByTypeView) view, 500, 500);

		} else if (c == '5') {

			View view = new PriceForHringTimeView(controller);
			crateStage((PriceForHringTimeView) view, 500, 200);

		} else if (c == '6') {
			View view = new ApartmentWithMostPriceView(controller);
			crateStage((ApartmentWithMostPriceView) view, 400, 350);

		} else if (c == '7') {
			View view = new AllClientsView(controller);
			crateStage((AllClientsView) view, 550, 500);

		} else if (c == '8') {
			View view = new CommtionView(controller);
			crateStage((CommtionView) view, 550, 300);

		} else if (c == '9') {
			View view = new CloneAptView(controller);
			crateStage((CloneAptView) view, 550, 700);

		} else {
			try {
				controller.saveAllApartmentToFile();
				Platform.exit();

			} catch (FileNotFoundException e) {
				new MessegeView(e.getMessage());
			} catch (IOException e) {
				new MessegeView(e.getMessage());
			}
		}
	}

	private void crateStage(Parent view, int width, int high) {
		Stage st = new Stage();
		Scene s = new Scene(view, width, high);

		st.setScene(s);
		st.show();

	}
	

}
