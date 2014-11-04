package models.ordenador;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import models.jugador.Jugador;

@Entity
public class MultiplesCriterios extends OrdenadorEquipos {

	@OneToMany 
	private List<OrdenadorEquipos> criterios;

	@Override
	public Double valoracion(Jugador jugador) {
		return criterios.stream()
				.mapToDouble(criterio -> criterio.valoracion(jugador))
				.average().getAsDouble();
	}

	public List<OrdenadorEquipos> getCriterios() {
		return criterios;
	}

	public void setCriterios(List<OrdenadorEquipos> criterios) {
		this.criterios = criterios;
	}
}