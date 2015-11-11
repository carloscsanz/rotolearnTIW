package es.rotolearn.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PROFESORES_ASOCIADOS database table.
 * 
 */
@Entity
@Table(name="PROFESORES_ASOCIADOS")
@NamedQuery(name="ProfesoresAsociado.findAll", query="SELECT p FROM ProfesoresAsociado p")
public class ProfesoresAsociado implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProfesoresAsociadoPK id;

	//bi-directional one-to-one association to Curso
	@OneToOne
	@JoinColumns({
		@JoinColumn(name="Curso", referencedColumnName="Titulo"),
		@JoinColumn(name="Profesor", referencedColumnName="Profesor")
		})
	private Curso cursoBean;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="Adjunto")
	private Usuario usuario;

	public ProfesoresAsociado() {
	}

	public ProfesoresAsociadoPK getId() {
		return this.id;
	}

	public void setId(ProfesoresAsociadoPK id) {
		this.id = id;
	}

	public Curso getCursoBean() {
		return this.cursoBean;
	}

	public void setCursoBean(Curso cursoBean) {
		this.cursoBean = cursoBean;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}