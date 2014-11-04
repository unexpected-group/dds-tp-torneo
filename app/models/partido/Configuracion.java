package models.partido;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import models.armador.ArmadorEquipos;
import models.ordenador.OrdenadorEquipos;
import play.db.ebean.Model;

@Entity
public class Configuracion extends Model{
	
	@Id
	private long id;
	@OneToOne
	private OrdenadorEquipos ordenadorEquipos;
	@OneToOne
	private ArmadorEquipos armadorEquipos;
	
	public Configuracion(OrdenadorEquipos ordenadorEquipos, ArmadorEquipos armadorEquipos) {
		super();
		this.ordenadorEquipos = ordenadorEquipos;
		this.armadorEquipos = armadorEquipos;
	}

	public OrdenadorEquipos getOrdenadorEquipos() {
		return ordenadorEquipos;
	}

	public void setOrdenadorEquipos(OrdenadorEquipos ordenadorEquipos) {
		this.ordenadorEquipos = ordenadorEquipos;
	}

	public ArmadorEquipos getArmadorEquipos() {
		return armadorEquipos;
	}

	public void setArmadorEquipos(ArmadorEquipos armadorEquipos) {
		this.armadorEquipos = armadorEquipos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}