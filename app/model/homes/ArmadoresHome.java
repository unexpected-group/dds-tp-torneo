package model.homes;

import java.util.ArrayList;
import java.util.List;

public class ArmadoresHome {

	private static List<String> opciones;

	public static List<String> getOpciones() {
		opciones = new ArrayList<String>();
		opciones.add("Posiciones pares e impares");
		opciones.add("Posiciones preestablecidas");
		return opciones;
	}
}