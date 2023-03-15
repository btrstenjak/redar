package hr.hrcity.eredar.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "skins")
public class Skins {

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
	
	@Column(nullable = false)
    @NotEmpty
	private String adresa;
	
	@Column(nullable = false)
    @NotEmpty
	private String rez;
	
	
	@Column(nullable = false)
    @NotEmpty
	private String slika;
	
	@Column
	private LocalDateTime datum;

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

	public LocalDateTime getDatum() {
		return datum;
	}

	public void setDatum(LocalDateTime datum) {
		this.datum = datum;
	}

	@Override
	public String toString() {
		return "Skins [id_skin=" + id_skin + ", geo_latitude=" + geo_latitude + ", geo_longitude=" + geo_longitude
				+ ", path=" + path + ", adresa=" + adresa + ", rez=" + rez + ", slika=" + slika + ", datum=" + datum
				+ "]";
	}

	public boolean equals(Object ob){  
        if(this==ob)          
             return true;  
        if(!(ob instanceof Skins))  
             return false;  
         //assume getter method in MyClass and this class has private variable myName, herName  
         return rez.equals(((Skins)ob).getId_skin()) ;      
     } 

}
