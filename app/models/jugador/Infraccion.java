package models.jugador;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import play.data.format.Formats.DateTime;
import play.db.ebean.Model;


@Entity 
@Table(name = "infracciones")
public class Infraccion extends Model {
	
	@Id @GeneratedValue
	private long id;
	
	@DateTime(pattern="dd/MM/yyyy")
	private Date fecha;
	private String motivo;

	public Infraccion(String motivo) {
		this.fecha = new Date();
		this.motivo = motivo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
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
	
	public static Finder<Long, Infraccion> getFind() {
		return find;
	}

	public static void setFind(Finder<Long, Infraccion> find) {
		Infraccion.find = find;
	}

	public static Finder<Long, Infraccion> find =
			new Finder<Long, Infraccion>(Long.class, Infraccion.class);
}