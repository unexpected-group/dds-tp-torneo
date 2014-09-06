package model.excepciones;

@SuppressWarnings("serial")
public class JugadorNoInscriptoException extends RuntimeException {
	public JugadorNoInscriptoException(String message) {
		super(message);
	}
}
