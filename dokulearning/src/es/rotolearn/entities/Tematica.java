package es.rotolearn.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TEMATICA database table.
 * 
 */
@Entity
@Table(name="TEMATICA")
@NamedQuery(name="Tematica.findAll", query="SELECT t FROM Tematica t")
public class Tematica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Tema")
	private String tema;

	//bi-directional many-to-one association to Curso
	@OneToMany(mappedBy="tematicaBean")
	private List<Curso> cursos;

	public Tematica() {
	}

	public String getTema() {
		return this.tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public List<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Curso addCurso(Curso curso) {
		getCursos().add(curso);
		curso.setTematicaBean(this);

		return curso;
	}

	public Curso removeCurso(Curso curso) {
		getCursos().remove(curso);
		curso.setTematicaBean(null);

		return curso;
	}

}