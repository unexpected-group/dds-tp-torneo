package models.all;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import models.all.Jugador;

@Entity
@DiscriminatorValue("M")
public class MultiplesCriterios extends OrdenadorEquipos {

	@OneToMany @JoinColumn(name = "criterio_id")
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