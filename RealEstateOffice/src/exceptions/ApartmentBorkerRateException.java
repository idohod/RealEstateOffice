package exceptions;

public class ApartmentBorkerRateException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ApartmentBorkerRateException() {
		super();
	}

	public ApartmentBorkerRateException(String msg) {
		super(msg);
	}
}
