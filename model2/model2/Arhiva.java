package hr.hrcity.eredar.model;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "arhiva")
public class Arhiva {

	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Timestamp datum;
	
	@Column(nullable = false)
    @NotEmpty
	private String naziv;
	
	@Column(nullable = false)
    @NotEmpty
	private String putanja;

	public Timestamp getDatum() {
		return datum;
	}

	public void setDatum(Timestamp datum) {
		this.datum = datum;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getPutanja() {
		return putanja;
	}

	public void setPutanja(String putanja) {
		this.putanja = putanja;
	}

	@Override
	public String toString() {
		return "Arhiva [datum=" + datum + ", naziv=" + naziv + ", putanja=" + putanja + "]";
	}
	
	public boolean equals(Object ob){  
        if(this==ob)          
             return true;  
        if(!(ob instanceof Arhiva))  
             return false;  
         //assume getter method in MyClass and this class has private variable myName, herName  
         return naziv.equals(((Arhiva)ob).getDatum()) ;      
     } 
	
}
