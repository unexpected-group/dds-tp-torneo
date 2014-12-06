package models.all;

import java.util.List;

import models.all.ArmadorEquipos;

public class ArmadoresHome {

	public static List<ArmadorEquipos> getOpciones() {
		return ArmadorEquipos.finder.all();
	}
}