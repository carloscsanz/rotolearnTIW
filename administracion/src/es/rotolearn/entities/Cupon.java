package es.rotolearn.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the CUPON database table.
 * 
 */
@Entity
@Table(name="CUPON")
@NamedQuery(name="Cupon.findAll", query="SELECT c FROM Cupon c")
public class Cupon implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CuponPK id;

	@Column(name="Cantidad_Porcentaje")
	private int cantidad_Porcentaje;

	@Column(name="Codigo_Descuento")
	private String codigo_Descuento;

	@Temporal(TemporalType.DATE)
	@Column(name="Fecha_Caducidad")
	private Date fecha_Caducidad;

	//bi-directional many-to-one association to TipoCupon
	@ManyToOne
	@JoinColumn(name="Tipo_Cupon")
	private TipoCupon tipoCupon;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="Curso", referencedColumnName="Titulo"),
		@JoinColumn(name="Profesor", referencedColumnName="Profesor")
		})
	private Curso cursoBean;

	public Cupon() {
	}

	public CuponPK getId() {
		return this.id;
	}

	public void setId(CuponPK id) {
		this.id = id;
	}

	public int getCantidad_Porcentaje() {
		return this.cantidad_Porcentaje;
	}

	public void setCantidad_Porcentaje(int cantidad_Porcentaje) {
		this.cantidad_Porcentaje = cantidad_Porcentaje;
	}

	public String getCodigo_Descuento() {
		return this.codigo_Descuento;
	}

	public void setCodigo_Descuento(String codigo_Descuento) {
		this.codigo_Descuento = codigo_Descuento;
	}

	public Date getFecha_Caducidad() {
		return this.fecha_Caducidad;
	}

	public void setFecha_Caducidad(Date fecha_Caducidad) {
		this.fecha_Caducidad = fecha_Caducidad;
	}

	public TipoCupon getTipoCupon() {
		return this.tipoCupon;
	}

	public void setTipoCupon(TipoCupon tipoCupon) {
		this.tipoCupon = tipoCupon;
	}

	public Curso getCursoBean() {
		return this.cursoBean;
	}

	public void setCursoBean(Curso cursoBean) {
		this.cursoBean = cursoBean;
	}

}