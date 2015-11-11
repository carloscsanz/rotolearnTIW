package es.rotolearn.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ESTADO_CURSO database table.
 * 
 */
@Entity
@Table(name="ESTADO_CURSO")
@NamedQuery(name="EstadoCurso.findAll", query="SELECT e FROM EstadoCurso e")
public class EstadoCurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Estado")
	private String estado;

	public EstadoCurso() {
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}