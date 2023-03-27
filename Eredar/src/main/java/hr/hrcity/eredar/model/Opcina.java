package hr.hrcity.eredar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "opcina")
public class Opcina {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_opcina;
	
	@Column

	private long id_upravitelj;

	
	@Column
	private String naziv_opcine;


	@Column
	private String zupanija;


	public long getId_opcina() {
		return id_opcina;
	}


	public void setId_opcina(long id_opcina) {
		this.id_opcina = id_opcina;
	}


	public long getId_upravitelj() {
		return id_upravitelj;
	}


	public void setId_upravitelj(long id_upravitelj) {
		this.id_upravitelj = id_upravitelj;
	}


	public String getNaziv_opcine() {
		return naziv_opcine;
	}


	public void setNaziv_opcine(String naziv_opcine) {
		this.naziv_opcine = naziv_opcine;
	}


	public String getZupanija() {
		return zupanija;
	}


	public void setZupanija(String zupanija) {
		this.zupanija = zupanija;
	}


	@Override
	public String toString() {
		return "opcina [id_opcina=" + id_opcina + ", id_upravitelj=" + id_upravitelj + ", naziv_opcine=" + naziv_opcine
				+ ", zupanija=" + zupanija + "]";
	}
	
}
