package models.excepciones;

@SuppressWarnings("serial")
public class NoSeCumpleCondicionException extends RuntimeException {

	public NoSeCumpleCondicionException(String message) {
		super(message);
	}
}
