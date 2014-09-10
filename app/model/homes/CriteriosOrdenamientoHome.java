package model.homes;

import java.util.ArrayList;
import java.util.List;

public class CriteriosOrdenamientoHome {

	private static List<String> opciones;

	public static List<String> getOpciones() {
		opciones = new ArrayList<String>();
		opciones.add("Handicap");
		opciones.add("Promedio del ultimo partido");
		opciones.add("Promedio de las ultimas calificaciones");
		return opciones;
	}
}