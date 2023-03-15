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
	private Integer kvota;
	
	@Column
	private double latitude;
	
	@Column
	private double longitude;
	
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

	public Integer getKvota() {
		return kvota;
	}

	public void setKvota(Integer kvota) {
		this.kvota = kvota;
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
		return "Opcina_lokacija [id_opcina=" + id_opcina + ", kvota=" + kvota + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", naziv=" + naziv + ", email=" + email + "]";
	}

	public boolean equals(Object ob){  
        if(this==ob)          
             return true;  
        if(!(ob instanceof Opcina_lokacija))  
             return false;  
         //assume getter method in MyClass and this class has private variable myName, herName  
         return naziv.equals(((Opcina_lokacija)ob).getId_opcina()) ;      
     } 
}

