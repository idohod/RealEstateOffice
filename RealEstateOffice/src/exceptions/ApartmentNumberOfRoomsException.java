package exceptions;

public class ApartmentNumberOfRoomsException extends RuntimeException {
	private static final long serialVersionUID = -3734700942240468739L;

	public ApartmentNumberOfRoomsException() {
		super();

	}

	public ApartmentNumberOfRoomsException(String msg) {
		super(msg);
	}
}
