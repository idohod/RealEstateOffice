package exceptions;

public class ApartmentException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ApartmentException() {
		super();

	}

	public ApartmentException(String msg) {
		super(msg);
	}
}
