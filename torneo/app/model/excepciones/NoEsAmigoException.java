package model.excepciones;

@SuppressWarnings("serial")
public class NoEsAmigoException extends RuntimeException {
	
	public NoEsAmigoException(String message) {
		super(message);
	}
}
