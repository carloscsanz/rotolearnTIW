package es.rotolearn.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the LECCION database table.
 * 
 */
@Embeddable
public class LeccionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="Curso", insertable=false, updatable=false)
	private String curso;

	@Column(name="Profesor", insertable=false, updatable=false)
	private String profesor;

	@Column(name="Seccion", insertable=false, updatable=false)
	private String seccion;

	@Column(name="Nombre")
	private String nombre;

	public LeccionPK() {
	}
	public String getCurso() {
		return this.curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getProfesor() {
		return this.profesor;
	}
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	public String getSeccion() {
		return this.seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LeccionPK)) {
			return false;
		}
		LeccionPK castOther = (LeccionPK)other;
		return 
			this.curso.equals(castOther.curso)
			&& this.profesor.equals(castOther.profesor)
			&& this.seccion.equals(castOther.seccion)
			&& this.nombre.equals(castOther.nombre);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.curso.hashCode();
		hash = hash * prime + this.profesor.hashCode();
		hash = hash * prime + this.seccion.hashCode();
		hash = hash * prime + this.nombre.hashCode();
		
		return hash;
	}
}