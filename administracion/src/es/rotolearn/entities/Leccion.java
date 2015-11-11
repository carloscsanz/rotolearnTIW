package es.rotolearn.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the LECCION database table.
 * 
 */
@Entity
@Table(name="LECCION")
@NamedQuery(name="Leccion.findAll", query="SELECT l FROM Leccion l")
public class Leccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LeccionPK id;

	@Column(name="Descripcion")
	private String descripcion;

	@Column(name="Evaluacion")
	private String evaluacion;

	@Column(name="Validad")
	private byte validad;

	//bi-directional many-to-one association to Seccion
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="Curso", referencedColumnName="Curso"),
		@JoinColumn(name="Profesor", referencedColumnName="Profesor"),
		@JoinColumn(name="Seccion", referencedColumnName="Nombre")
		})
	private Seccion seccionBean;

	//bi-directional many-to-one association to Material
	@OneToMany(mappedBy="leccionBean")
	private List<Material> materials;

	public Leccion() {
	}

	public LeccionPK getId() {
		return this.id;
	}

	public void setId(LeccionPK id) {
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

	public byte getValidad() {
		return this.validad;
	}

	public void setValidad(byte validad) {
		this.validad = validad;
	}

	public Seccion getSeccionBean() {
		return this.seccionBean;
	}

	public void setSeccionBean(Seccion seccionBean) {
		this.seccionBean = seccionBean;
	}

	public List<Material> getMaterials() {
		return this.materials;
	}

	public void setMaterials(List<Material> materials) {
		this.materials = materials;
	}

	public Material addMaterial(Material material) {
		getMaterials().add(material);
		material.setLeccionBean(this);

		return material;
	}

	public Material removeMaterial(Material material) {
		getMaterials().remove(material);
		material.setLeccionBean(null);

		return material;
	}

}