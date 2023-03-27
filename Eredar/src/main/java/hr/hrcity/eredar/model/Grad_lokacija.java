package hr.hrcity.eredar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "grad_lokacija")
public class Grad_lokacija {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_grad;
	
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

	public long getId_grad() {
		return id_grad;
	}

	public void setId_grad(long id_grad) {
		this.id_grad = id_grad;
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
		return "grad_lokacija [id_grad=" + id_grad + ", latitude=" + latitude + ", longitude=" + longitude + ", kvota="
				+ kvota + ", naziv=" + naziv + ", email=" + email + "]";
	}
	

}
