package exceptions;

public class ApartmentPriceException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ApartmentPriceException() {
		super();
		
	}
	
	public ApartmentPriceException(String msg) { 
		super(msg);
		
	}
}
