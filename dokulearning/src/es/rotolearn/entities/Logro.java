package es.rotolearn.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the LOGROS database table.
 * 
 */
@Entity
@Table(name="LOGROS")
@NamedQuery(name="Logro.findAll", query="SELECT l FROM Logro l")
public class Logro implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LogroPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="Fecha_Conseguido")
	private Date fecha_Conseguido;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="Usuario")
	private Usuario usuarioBean;

	public Logro() {
	}

	public LogroPK getId() {
		return this.id;
	}

	public void setId(LogroPK id) {
		this.id = id;
	}

	public Date getFecha_Conseguido() {
		return this.fecha_Conseguido;
	}

	public void setFecha_Conseguido(Date fecha_Conseguido) {
		this.fecha_Conseguido = fecha_Conseguido;
	}

	public Usuario getUsuarioBean() {
		return this.usuarioBean;
	}

	public void setUsuarioBean(Usuario usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

}