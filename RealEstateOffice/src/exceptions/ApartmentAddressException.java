package exceptions;

public class ApartmentAddressException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ApartmentAddressException() {
		super();
		
	}
	
	public ApartmentAddressException(String msg) { 
		super(msg);
		
	}
}
