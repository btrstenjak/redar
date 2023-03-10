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
	
	@Column(nullable = false)
    @NotEmpty
	private  String naziv;
	
	@Column
	private long latitude;
	
	@Column
	private long longitude;
	
	@Column(nullable = false)
    @NotEmpty
	private  String email;
	
	@Column
	private long kvota;

	public long getId_grad() {
		return id_grad;
	}

	public void setId_grad(long id_grad) {
		this.id_grad = id_grad;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public long getLatitude() {
		return latitude;
	}

	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}

	public long getLongitude() {
		return longitude;
	}

	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getKvota() {
		return kvota;
	}

	public void setKvota(long kvota) {
		this.kvota = kvota;
	}

	@Override
	public String toString() {
		return "grad lokacija [id_grad=" + id_grad + ", naziv=" + naziv + ", latitude=" + latitude + ", longitude="
				+ longitude + ", email=" + email + ", kvota=" + kvota + "]";
	}
	
	public boolean equals(Object ob){  
        if(this==ob)          
             return true;  
        if(!(ob instanceof Grad))  
             return false;  
         //assume getter method in MyClass and this class has private variable myName, herName  
         return naziv.equals(((Grad_lokacija)ob).getId_grad()) ;      
     } 
	
	

}