package hr.hrcity.eredar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "opcina_lokacija")
public class Opcina_lokacija {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_opcina;
	
	@Column
	private double latitude;
	
	@Column
	private double longitude;
	
	@Column
	private int kvota;
	
	@Column(nullable = false)
    @NotEmpty
	private String naziv;
	
	
	@Column(nullable = false)
    @NotEmpty
	private String email;


	public long getId_opcina() {
		return id_opcina;
	}


	public void setId_opcina(long id_opcina) {
		this.id_opcina = id_opcina;
	}


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public int getKvota() {
		return kvota;
	}


	public void setKvota(int kvota) {
		this.kvota = kvota;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Opcina_lokacija [id_opcina=" + id_opcina + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", kvota=" + kvota + ", naziv=" + naziv + ", email=" + email + "]";
	}
	
	
}
