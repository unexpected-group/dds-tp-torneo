package models.inscripcion;

import com.avaje.ebean.annotation.EnumValue;

public enum Prioridad {
	@EnumValue("C")
	CONDICIONAL,
	@EnumValue("S")
	SOLIDARIO,
	@EnumValue("E")
	ESTANDAR
}