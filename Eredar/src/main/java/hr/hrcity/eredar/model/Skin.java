package hr.hrcity.eredar.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "skin")
public class Skin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_skin;


	@Column
	private double geo_latitude;
	
	@Column
	private double geo_longitude;
	
	@Column(nullable = false)
    @NotEmpty
	private String path;

	
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date datum;
	
	@Column(nullable = false)
    @NotEmpty
	private String adresa;
	
	@Column(nullable = false)
    @NotEmpty
	private String rez;
	
	@Column(nullable = false)
    @NotEmpty
	private String slika;
	
	
	
	public long getId_skin() {
		return id_skin;
	}



	public void setId_skin(long id_skin) {
		this.id_skin = id_skin;
	}



	public double getGeo_latitude() {
		return geo_latitude;
	}



	public void setGeo_latitude(double geo_latitude) {
		this.geo_latitude = geo_latitude;
	}



	public double getGeo_longitude() {
		return geo_longitude;
	}



	public void setGeo_longitude(double geo_longitude) {
		this.geo_longitude = geo_longitude;
	}



	public String getPath() {
		return path;
	}



	public void setPath(String path) {
		this.path = path;
	}



	public Date getDatum() {
		return datum;
	}



	public void setDatum(Date datum) {
		this.datum = datum;
	}



	public String getAdresa() {
		return adresa;
	}



	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}



	public String getRez() {
		return rez;
	}



	public void setRez(String rez) {
		this.rez = rez;
	}



	public String getSlika() {
		return slika;
	}



	public void setSlika(String slika) {
		this.slika = slika;
	}



	@Override
	public String toString() {
		return "Skin [id_skin=" + id_skin + ", geo_latitude=" + geo_latitude + ", geo_longitude=" + geo_longitude
				+ ", path=" + path + ", datum=" + datum + ", adresa=" + adresa + ", rez=" + rez + ", slika=" + slika
				+ "]";
	}
	
}