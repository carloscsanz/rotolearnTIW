package es.rotolearn.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MATERIAL database table.
 * 
 */
@Entity
@Table(name="MATERIAL")
@NamedQuery(name="Material.findAll", query="SELECT m FROM Material m")
public class Material implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MaterialPK id;

	@Column(name="Descripcioni")
	private String descripcioni;

	@Column(name="Material_Link")
	private String material_Link;

	@Column(name="Validado")
	private byte validado;

	//bi-directional many-to-one association to Leccion
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="Curso", referencedColumnName="Curso"),
		@JoinColumn(name="Leccion", referencedColumnName="Nombre"),
		@JoinColumn(name="Profesor", referencedColumnName="Profesor"),
		@JoinColumn(name="Seccion", referencedColumnName="Seccion")
		})
	private Leccion leccionBean;

	public Material() {
	}

	public MaterialPK getId() {
		return this.id;
	}

	public void setId(MaterialPK id) {
		this.id = id;
	}

	public String getDescripcioni() {
		return this.descripcioni;
	}

	public void setDescripcioni(String descripcioni) {
		this.descripcioni = descripcioni;
	}

	public String getMaterial_Link() {
		return this.material_Link;
	}

	public void setMaterial_Link(String material_Link) {
		this.material_Link = material_Link;
	}

	public byte getValidado() {
		return this.validado;
	}

	public void setValidado(byte validado) {
		this.validado = validado;
	}

	public Leccion getLeccionBean() {
		return this.leccionBean;
	}

	public void setLeccionBean(Leccion leccionBean) {
		this.leccionBean = leccionBean;
	}

}