package exceptions;

public class ApartmentHiringTimeException extends RuntimeException {
	private static final long serialVersionUID = -5897307983590438669L;

	public ApartmentHiringTimeException() {
		super();

	}

	public ApartmentHiringTimeException(String msg) {
		super(msg);
	}
}
