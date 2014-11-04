package models.propuesta;

import com.avaje.ebean.annotation.EnumValue;

public enum Estado {
	@EnumValue("A")
	ACEPTADA,
	@EnumValue("P")
	PENDIENTE, 
	@EnumValue("R")
	RECHAZADA
}