package es.rotolearn.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the LOGROS database table.
 * 
 */
@Embeddable
public class LogroPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="Usuario", insertable=false, updatable=false)
	private String usuario;

	@Column(name="Logro")
	private String logro;

	public LogroPK() {
	}
	public String getUsuario() {
		return this.usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getLogro() {
		return this.logro;
	}
	public void setLogro(String logro) {
		this.logro = logro;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LogroPK)) {
			return false;
		}
		LogroPK castOther = (LogroPK)other;
		return 
			this.usuario.equals(castOther.usuario)
			&& this.logro.equals(castOther.logro);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.usuario.hashCode();
		hash = hash * prime + this.logro.hashCode();
		
		return hash;
	}
}