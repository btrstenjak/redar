package hr.hrcity.eredar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity

@Table(name = "crna_lista")
public class Crna_lista {


	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_crna;




	@Column 
	private String email;

	@Column 
	private String datum;


	@Column 
	private String mac;


	@Column 
	private Integer razlog;

	public Integer getId_crna() {
		return id_crna;
	}


	public void setId_crna(Integer id_crna) {
		this.id_crna = id_crna;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDatum() {
		return datum;
	}


	public void setDatum(String datum) {
		this.datum = datum;
	}


	public String getMac() {
		return mac;
	}


	public void setMac(String mac) {
		this.mac = mac;
	}


	public Integer getRazlog() {
		return razlog;
	}


	public void setRazlog(Integer razlog) {
		this.razlog = razlog;
	}

	@Override


	public String toString() {
		return "crna lista [id_crna=" + id_crna + ", email=" + email + ", datum=" + datum + ", mac="
				+ mac  + ", razlog=" +razlog + "]";
	}

	public boolean equals(Object ob){  
        if(this==ob)          
             return true;  
        if(!(ob instanceof Crna_lista))  
             return false;  

         return email.equals(((Crna_lista)ob).getId_crna()) ;      
     } 

}