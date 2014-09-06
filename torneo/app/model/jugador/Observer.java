package model.jugador;

public interface Observer {

	public void notificarNuevaInscripcion(Jugador jugador);

	public void notificarBaja();
}