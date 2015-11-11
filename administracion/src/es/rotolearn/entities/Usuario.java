package es.rotolearn.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the USUARIO database table.
 * 
 */
@Entity
@Table(name="USUARIO")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Nickname")
	private String nickname;

	@Column(name="Apellido1")
	private String apellido1;

	@Column(name="Apellido2")
	private String apellido2;

	@Column(name="Descripcion")
	private String descripcion;

	@Column(name="Direccion")
	private String direccion;

	@Column(name="Email")
	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name="Fecha_Nacimiento")
	private Date fecha_Nacimiento;

	@Column(name="Imagen")
	private String imagen;

	@Column(name="Intereses")
	private String intereses;

	@Column(name="Nombre")
	private String nombre;

	@Column(name="Pass")
	private String pass;

	@Column(name="Profesor")
	private byte profesor;

	@Column(name="Telefono")
	private String telefono;

	//bi-directional many-to-one association to Curso
	@OneToMany(mappedBy="usuario")
	private List<Curso> cursos;

	//bi-directional many-to-one association to Logro
	@OneToMany(mappedBy="usuarioBean")
	private List<Logro> logros;

	//bi-directional many-to-one association to ProfesoresAsociado
	@OneToMany(mappedBy="usuario")
	private List<ProfesoresAsociado> profesoresAsociados;

	public Usuario() {
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFecha_Nacimiento() {
		return this.fecha_Nacimiento;
	}

	public void setFecha_Nacimiento(Date fecha_Nacimiento) {
		this.fecha_Nacimiento = fecha_Nacimiento;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getIntereses() {
		return this.intereses;
	}

	public void setIntereses(String intereses) {
		this.intereses = intereses;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public byte getProfesor() {
		return this.profesor;
	}

	public void setProfesor(byte profesor) {
		this.profesor = profesor;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Curso addCurso(Curso curso) {
		getCursos().add(curso);
		curso.setUsuario(this);

		return curso;
	}

	public Curso removeCurso(Curso curso) {
		getCursos().remove(curso);
		curso.setUsuario(null);

		return curso;
	}

	public List<Logro> getLogros() {
		return this.logros;
	}

	public void setLogros(List<Logro> logros) {
		this.logros = logros;
	}

	public Logro addLogro(Logro logro) {
		getLogros().add(logro);
		logro.setUsuarioBean(this);

		return logro;
	}

	public Logro removeLogro(Logro logro) {
		getLogros().remove(logro);
		logro.setUsuarioBean(null);

		return logro;
	}

	public List<ProfesoresAsociado> getProfesoresAsociados() {
		return this.profesoresAsociados;
	}

	public void setProfesoresAsociados(List<ProfesoresAsociado> profesoresAsociados) {
		this.profesoresAsociados = profesoresAsociados;
	}

	public ProfesoresAsociado addProfesoresAsociado(ProfesoresAsociado profesoresAsociado) {
		getProfesoresAsociados().add(profesoresAsociado);
		profesoresAsociado.setUsuario(this);

		return profesoresAsociado;
	}

	public ProfesoresAsociado removeProfesoresAsociado(ProfesoresAsociado profesoresAsociado) {
		getProfesoresAsociados().remove(profesoresAsociado);
		profesoresAsociado.setUsuario(null);

		return profesoresAsociado;
	}

}