package es.rotolearn.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CURSO database table.
 * 
 */
@Entity
@Table(name="CURSO")
@NamedQuery(name="Curso.findAll", query="SELECT c FROM Curso c")
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CursoPK id;

	@Column(name="Borrado")
	private byte borrado;

	@Column(name="Certificado")
	private String certificado;

	@Column(name="Descripcion")
	private String descripcion;

	@Column(name="Destacado")
	private byte destacado;

	@Column(name="Email_paypal")
	private String email_paypal;

	@Column(name="Evaluacion")
	private String evaluacion;

	@Column(name="Imagen")
	private String imagen;

	@Column(name="N_Horas")
	private int n_Horas;

	@Column(name="Precio")
	private int precio;

	@Column(name="Validado")
	private byte validado;

	//bi-directional many-to-one association to Cupon
	@OneToMany(mappedBy="cursoBean")
	private List<Cupon> cupons;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="Profesor")
	private Usuario usuario;

	//bi-directional many-to-one association to Dificultad
	@ManyToOne
	@JoinColumn(name="Dificultad")
	private Dificultad dificultadBean;

	//bi-directional many-to-one association to Tematica
	@ManyToOne
	@JoinColumn(name="Tematica")
	private Tematica tematicaBean;

	//bi-directional one-to-one association to ProfesoresAsociado
	@OneToOne(mappedBy="cursoBean")
	private ProfesoresAsociado profesoresAsociado;

	//bi-directional many-to-one association to Seccion
	@OneToMany(mappedBy="cursoBean")
	private List<Seccion> seccions;

	public Curso() {
	}

	public CursoPK getId() {
		return this.id;
	}

	public void setId(CursoPK id) {
		this.id = id;
	}

	public byte getBorrado() {
		return this.borrado;
	}

	public void setBorrado(byte borrado) {
		this.borrado = borrado;
	}

	public String getCertificado() {
		return this.certificado;
	}

	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public byte getDestacado() {
		return this.destacado;
	}

	public void setDestacado(byte destacado) {
		this.destacado = destacado;
	}

	public String getEmail_paypal() {
		return this.email_paypal;
	}

	public void setEmail_paypal(String email_paypal) {
		this.email_paypal = email_paypal;
	}

	public String getEvaluacion() {
		return this.evaluacion;
	}

	public void setEvaluacion(String evaluacion) {
		this.evaluacion = evaluacion;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getN_Horas() {
		return this.n_Horas;
	}

	public void setN_Horas(int n_Horas) {
		this.n_Horas = n_Horas;
	}

	public int getPrecio() {
		return this.precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public byte getValidado() {
		return this.validado;
	}

	public void setValidado(byte validado) {
		this.validado = validado;
	}

	public List<Cupon> getCupons() {
		return this.cupons;
	}

	public void setCupons(List<Cupon> cupons) {
		this.cupons = cupons;
	}

	public Cupon addCupon(Cupon cupon) {
		getCupons().add(cupon);
		cupon.setCursoBean(this);

		return cupon;
	}

	public Cupon removeCupon(Cupon cupon) {
		getCupons().remove(cupon);
		cupon.setCursoBean(null);

		return cupon;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Dificultad getDificultadBean() {
		return this.dificultadBean;
	}

	public void setDificultadBean(Dificultad dificultadBean) {
		this.dificultadBean = dificultadBean;
	}

	public Tematica getTematicaBean() {
		return this.tematicaBean;
	}

	public void setTematicaBean(Tematica tematicaBean) {
		this.tematicaBean = tematicaBean;
	}

	public ProfesoresAsociado getProfesoresAsociado() {
		return this.profesoresAsociado;
	}

	public void setProfesoresAsociado(ProfesoresAsociado profesoresAsociado) {
		this.profesoresAsociado = profesoresAsociado;
	}

	public List<Seccion> getSeccions() {
		return this.seccions;
	}

	public void setSeccions(List<Seccion> seccions) {
		this.seccions = seccions;
	}

	public Seccion addSeccion(Seccion seccion) {
		getSeccions().add(seccion);
		seccion.setCursoBean(this);

		return seccion;
	}

	public Seccion removeSeccion(Seccion seccion) {
		getSeccions().remove(seccion);
		seccion.setCursoBean(null);

		return seccion;
	}

}