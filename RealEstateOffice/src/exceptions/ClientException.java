package exceptions;

public class ClientException extends RuntimeException {
	private static final long serialVersionUID = 587228431278503626L;

	public ClientException() {
		super();
	}

	public ClientException(String msg) {
		super(msg);
	}
}
