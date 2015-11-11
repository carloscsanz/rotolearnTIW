package es.rotolearn.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CURSO_ALUMNO database table.
 * 
 */
@Entity
@Table(name="CURSO_ALUMNO")
@NamedQuery(name="CursoAlumno.findAll", query="SELECT c FROM CursoAlumno c")
public class CursoAlumno implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CursoAlumnoPK id;

	@Column(name="Estado")
	private String estado;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="Profesor", referencedColumnName="Titulo"),
		@JoinColumn(name="Titulo", referencedColumnName="Profesor")
		})
	private Curso curso;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="Nickname")
	private Usuario usuario;

	public CursoAlumno() {
	}

	public CursoAlumnoPK getId() {
		return this.id;
	}

	public void setId(CursoAlumnoPK id) {
		this.id = id;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}