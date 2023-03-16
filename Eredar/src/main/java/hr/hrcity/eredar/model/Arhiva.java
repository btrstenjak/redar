package hr.hrcity.eredar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;




@Entity
@Table(name = "arhiva")
public class Arhiva {
	
	@Id
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date datum;
	
	

    

	@Column(nullable = false)
    private String naziv;
    
    @Column(nullable = false)
    private String putanja;

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
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
        if(!(ob instanceof Crna_lista))  
             return false;  

         return naziv.equals(((Crna_lista)ob).getDatum()) ;     

}
	
}