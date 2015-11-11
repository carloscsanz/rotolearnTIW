package es.rotolearn.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the MATERIAL database table.
 * 
 */
@Embeddable
public class MaterialPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="Curso", insertable=false, updatable=false)
	private String curso;

	@Column(name="Profesor", insertable=false, updatable=false)
	private String profesor;

	@Column(name="Seccion", insertable=false, updatable=false)
	private String seccion;

	@Column(name="Leccion", insertable=false, updatable=false)
	private String leccion;

	@Column(name="Nombre_ID")
	private String nombre_ID;

	public MaterialPK() {
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
	public String getLeccion() {
		return this.leccion;
	}
	public void setLeccion(String leccion) {
		this.leccion = leccion;
	}
	public String getNombre_ID() {
		return this.nombre_ID;
	}
	public void setNombre_ID(String nombre_ID) {
		this.nombre_ID = nombre_ID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MaterialPK)) {
			return false;
		}
		MaterialPK castOther = (MaterialPK)other;
		return 
			this.curso.equals(castOther.curso)
			&& this.profesor.equals(castOther.profesor)
			&& this.seccion.equals(castOther.seccion)
			&& this.leccion.equals(castOther.leccion)
			&& this.nombre_ID.equals(castOther.nombre_ID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.curso.hashCode();
		hash = hash * prime + this.profesor.hashCode();
		hash = hash * prime + this.seccion.hashCode();
		hash = hash * prime + this.leccion.hashCode();
		hash = hash * prime + this.nombre_ID.hashCode();
		
		return hash;
	}
}