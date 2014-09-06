package model.jugador;

import java.time.LocalDate;

public class Infraccion {

	private LocalDate fecha;
	private String motivo;

	public Infraccion(String motivo) {
		super();
		this.fecha = LocalDate.now();
		this.motivo = motivo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
}