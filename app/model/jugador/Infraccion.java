package model.jugador;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Infraccion extends Model {
	
	@Id
	private long id;
	
	private LocalDate fecha;
	private String motivo;

	public Infraccion(String motivo) {
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}