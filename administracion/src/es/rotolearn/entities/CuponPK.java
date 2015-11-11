package es.rotolearn.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CUPON database table.
 * 
 */
@Embeddable
public class CuponPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="Curso", insertable=false, updatable=false)
	private String curso;

	@Column(name="Profesor", insertable=false, updatable=false)
	private String profesor;

	@Column(name="Tipo_Cupon", insertable=false, updatable=false)
	private String tipo_Cupon;

	public CuponPK() {
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
	public String getTipo_Cupon() {
		return this.tipo_Cupon;
	}
	public void setTipo_Cupon(String tipo_Cupon) {
		this.tipo_Cupon = tipo_Cupon;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CuponPK)) {
			return false;
		}
		CuponPK castOther = (CuponPK)other;
		return 
			this.curso.equals(castOther.curso)
			&& this.profesor.equals(castOther.profesor)
			&& this.tipo_Cupon.equals(castOther.tipo_Cupon);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.curso.hashCode();
		hash = hash * prime + this.profesor.hashCode();
		hash = hash * prime + this.tipo_Cupon.hashCode();
		
		return hash;
	}
}