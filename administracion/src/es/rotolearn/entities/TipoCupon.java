package es.rotolearn.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TIPO_CUPON database table.
 * 
 */
@Entity
@Table(name="TIPO_CUPON")
@NamedQuery(name="TipoCupon.findAll", query="SELECT t FROM TipoCupon t")
public class TipoCupon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Tipo")
	private String tipo;

	//bi-directional many-to-one association to Cupon
	@OneToMany(mappedBy="tipoCupon")
	private List<Cupon> cupons;

	public TipoCupon() {
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Cupon> getCupons() {
		return this.cupons;
	}

	public void setCupons(List<Cupon> cupons) {
		this.cupons = cupons;
	}

	public Cupon addCupon(Cupon cupon) {
		getCupons().add(cupon);
		cupon.setTipoCupon(this);

		return cupon;
	}

	public Cupon removeCupon(Cupon cupon) {
		getCupons().remove(cupon);
		cupon.setTipoCupon(null);

		return cupon;
	}

}