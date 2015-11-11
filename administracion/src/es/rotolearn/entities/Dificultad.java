package es.rotolearn.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DIFICULTAD database table.
 * 
 */
@Entity
@Table(name="DIFICULTAD")
@NamedQuery(name="Dificultad.findAll", query="SELECT d FROM Dificultad d")
public class Dificultad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Tipo")
	private String tipo;

	//bi-directional many-to-one association to Curso
	@OneToMany(mappedBy="dificultadBean")
	private List<Curso> cursos;

	public Dificultad() {
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Curso addCurso(Curso curso) {
		getCursos().add(curso);
		curso.setDificultadBean(this);

		return curso;
	}

	public Curso removeCurso(Curso curso) {
		getCursos().remove(curso);
		curso.setDificultadBean(null);

		return curso;
	}

}