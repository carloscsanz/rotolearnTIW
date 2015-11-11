package es.rotolearn.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SECCION database table.
 * 
 */
@Entity
@Table(name="SECCION")
@NamedQuery(name="Seccion.findAll", query="SELECT s FROM Seccion s")
public class Seccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SeccionPK id;

	@Column(name="Descripcion")
	private String descripcion;

	@Column(name="Evaluacion")
	private String evaluacion;

	@Column(name="Validado")
	private byte validado;

	//bi-directional many-to-one association to Leccion
	@OneToMany(mappedBy="seccionBean")
	private List<Leccion> leccions;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="Curso", referencedColumnName="Titulo"),
		@JoinColumn(name="Profesor", referencedColumnName="Profesor")
		})
	private Curso cursoBean;

	public Seccion() {
	}

	public SeccionPK getId() {
		return this.id;
	}

	public void setId(SeccionPK id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEvaluacion() {
		return this.evaluacion;
	}

	public void setEvaluacion(String evaluacion) {
		this.evaluacion = evaluacion;
	}

	public byte getValidado() {
		return this.validado;
	}

	public void setValidado(byte validado) {
		this.validado = validado;
	}

	public List<Leccion> getLeccions() {
		return this.leccions;
	}

	public void setLeccions(List<Leccion> leccions) {
		this.leccions = leccions;
	}

	public Leccion addLeccion(Leccion leccion) {
		getLeccions().add(leccion);
		leccion.setSeccionBean(this);

		return leccion;
	}

	public Leccion removeLeccion(Leccion leccion) {
		getLeccions().remove(leccion);
		leccion.setSeccionBean(null);

		return leccion;
	}

	public Curso getCursoBean() {
		return this.cursoBean;
	}

	public void setCursoBean(Curso cursoBean) {
		this.cursoBean = cursoBean;
	}

}