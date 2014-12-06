package models.all;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("P")
public class PromedioUltimoPartido extends OrdenadorEquipos {

	@OneToOne
	private Partido partido;

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public PromedioUltimoPartido(Partido partido) {
		this.partido = partido;
	}

	@Override
	public Double valoracion(Jugador jugador) {
		return jugador.promedioCalificacionesPartido(partido);
	}
}
