package model;

import java.util.ArrayList;
import java.util.Scanner;

public interface iMangment {

	Scanner s = new Scanner(System.in);

	String FILE_NAME = "allApartments.bin";

	boolean addApartment(Apartment apartment);

	boolean isApartmentContains(Apartment apartment);

	String allApartmentsByType(String str);

	String getAllCommissions(ArrayList<Apartment> allApartments);

	Apartment getFirstHireApartment();

	Apartment ApartmentWithMostPrice(int time);

	Apartment getApartmentFromInputIndex(int num);

	Apartment allApartmentData(int type,String address,double area,int rooms,int rate,int time,double price);

	String helpPrint();

}
