package es.rotolearn.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CURSO database table.
 * 
 */
@Embeddable
public class CursoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="Titulo")
	private String titulo;

	@Column(name="Profesor", insertable=false, updatable=false)
	private String profesor;

	public CursoPK() {
	}
	public String getTitulo() {
		return this.titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getProfesor() {
		return this.profesor;
	}
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CursoPK)) {
			return false;
		}
		CursoPK castOther = (CursoPK)other;
		return 
			this.titulo.equals(castOther.titulo)
			&& this.profesor.equals(castOther.profesor);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.titulo.hashCode();
		hash = hash * prime + this.profesor.hashCode();
		
		return hash;
	}
}