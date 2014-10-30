package model.partido;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;
import model.armador.ArmadorEquipos;
import model.ordenador.OrdenadorEquipos;

@Entity
public class Configuracion extends Model {
	
	@Id
	private long id;
	
	private OrdenadorEquipos ordenadorEquipos;
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
}