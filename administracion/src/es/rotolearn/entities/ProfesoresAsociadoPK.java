package es.rotolearn.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PROFESORES_ASOCIADOS database table.
 * 
 */
@Embeddable
public class ProfesoresAsociadoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="Curso", insertable=false, updatable=false)
	private String curso;

	@Column(name="Profesor", insertable=false, updatable=false)
	private String profesor;

	public ProfesoresAsociadoPK() {
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProfesoresAsociadoPK)) {
			return false;
		}
		ProfesoresAsociadoPK castOther = (ProfesoresAsociadoPK)other;
		return 
			this.curso.equals(castOther.curso)
			&& this.profesor.equals(castOther.profesor);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.curso.hashCode();
		hash = hash * prime + this.profesor.hashCode();
		
		return hash;
	}
}