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
	@Column(name="Fecha_nac")
	private Date fecha_nac;

	@Column(name="Imagen")
	private String imagen;

	@Column(name="Intereses")
	private String intereses;

	@Column(name="Nombre")
	private String nombre;

	@Column(name="Pass")
	private String pass;

	@Column(name="Telefono")
	private String telefono;

	@Column(name="Tipo")
	private String tipo;

	//bi-directional many-to-one association to Curso
	@OneToMany(mappedBy="usuario")
	private List<Curso> cursos1;

	//bi-directional many-to-many association to Curso
	@ManyToMany(mappedBy="usuarios")
	private List<Curso> cursos2;

	//bi-directional many-to-one association to CursoAlumno
	@OneToMany(mappedBy="usuario")
	private List<CursoAlumno> cursoAlumnos;

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

	public Date getFecha_nac() {
		return this.fecha_nac;
	}

	public void setFecha_nac(Date fecha_nac) {
		this.fecha_nac = fecha_nac;
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

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Curso> getCursos1() {
		return this.cursos1;
	}

	public void setCursos1(List<Curso> cursos1) {
		this.cursos1 = cursos1;
	}

	public Curso addCursos1(Curso cursos1) {
		getCursos1().add(cursos1);
		cursos1.setUsuario(this);

		return cursos1;
	}

	public Curso removeCursos1(Curso cursos1) {
		getCursos1().remove(cursos1);
		cursos1.setUsuario(null);

		return cursos1;
	}

	public List<Curso> getCursos2() {
		return this.cursos2;
	}

	public void setCursos2(List<Curso> cursos2) {
		this.cursos2 = cursos2;
	}

	public List<CursoAlumno> getCursoAlumnos() {
		return this.cursoAlumnos;
	}

	public void setCursoAlumnos(List<CursoAlumno> cursoAlumnos) {
		this.cursoAlumnos = cursoAlumnos;
	}

	public CursoAlumno addCursoAlumno(CursoAlumno cursoAlumno) {
		getCursoAlumnos().add(cursoAlumno);
		cursoAlumno.setUsuario(this);

		return cursoAlumno;
	}

	public CursoAlumno removeCursoAlumno(CursoAlumno cursoAlumno) {
		getCursoAlumnos().remove(cursoAlumno);
		cursoAlumno.setUsuario(null);

		return cursoAlumno;
	}

}