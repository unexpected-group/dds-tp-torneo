package models.all;

import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import play.db.ebean.Model;

@Entity
@Table(name = "armadores")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class ArmadorEquipos extends Model {

	@Id
	@GeneratedValue
	private int id;

	public abstract void armarEquipos(List<Jugador> jugadores);

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// finder for model

	public static Finder<Long, ArmadorEquipos> finder = 
			new Finder<Long, ArmadorEquipos>(Long.class, ArmadorEquipos.class);
}