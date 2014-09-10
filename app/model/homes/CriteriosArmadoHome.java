package model.homes;

import java.util.ArrayList;
import java.util.List;

public class CriteriosArmadoHome {

	private static List<String> opciones = new ArrayList<String>();

	public static List<String> getOpciones() {
		opciones.add("Posiciones pares e impares");
		opciones.add("Posiciones preestablecidas");
		return opciones;
	}
}