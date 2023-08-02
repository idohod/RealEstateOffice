package exceptions;

public class ApartmentAreaException extends RuntimeException {
	private static final long serialVersionUID = 528416507281408463L;

	public ApartmentAreaException() {
		super();
		
	}
	
	public ApartmentAreaException(String msg) { 
		super(msg);
		
	}
}
