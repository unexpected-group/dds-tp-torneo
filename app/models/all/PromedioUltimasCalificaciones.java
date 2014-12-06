package models.all;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("C")
public class PromedioUltimasCalificaciones extends OrdenadorEquipos {

	private int cantidad;
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public PromedioUltimasCalificaciones(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public Double valoracion(Jugador jugador) {
		return jugador.promedioUltimasCalificaciones(cantidad);
	}
}