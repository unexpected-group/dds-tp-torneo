package models.all;

import java.util.List;

public class ArmadoresHome {

	public static List<ArmadorEquipos> getOpciones() {
		return ArmadorEquipos.finder.all();
	}
}