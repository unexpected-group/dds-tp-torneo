package model.auto;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Auto extends Model {

	@Id
	private long id;

	private String marca;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public static Finder<Long, Auto> find = new Finder<Long, Auto>(Long.class, Auto.class);
}