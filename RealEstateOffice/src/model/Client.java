package model;

import java.io.Serializable;

public class Client  implements Cloneable ,Serializable{

	private String name;
	private String phoneNumber;

	public Client(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public Client clone() throws CloneNotSupportedException {
		Client temp =  (Client) super.clone();
		return temp; 
	}
	

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!obj.getClass().equals(getClass()))
			return false;
		Client other = (Client) obj;
		if (this.phoneNumber == null)
			return other.phoneNumber == null;
		return this.phoneNumber.equals(other.phoneNumber);
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Client:\n" + " name = " + name + "\n phoneNumber = " + phoneNumber + "\n";
	}	
	
	
		
		
		
}
