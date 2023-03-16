package hr.hrcity.eredar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "vrsta_prijava")
public class Vrsta_prijava {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_vrsta_prijava;
	
	@Column(nullable = false)
    @NotEmpty
	private String naziv_vrste;

	

	public String getNaziv_vrste() {
		return naziv_vrste;
	}

	public void setNaziv_vrste(String naziv_vrste) {
		this.naziv_vrste = naziv_vrste;
	}
	

	
	@Override
	public String toString() {
		return "Vrsta_prijava [naziv_vrste=" + naziv_vrste + "]";
	}
	
	
	public Integer getId_vrsta_prijava() {
		return id_vrsta_prijava;
	}

	public void setId_vrsta_prijava(Integer id_vrsta_prijava) {
		this.id_vrsta_prijava = id_vrsta_prijava;
	}

	public boolean equals(Object ob){  
        if(this==ob)          
             return true;  
        if(!(ob instanceof Vrsta_prijava))  
             return false;  
         //assume getter method in MyClass and this class has private variable myName, herName  
         return naziv_vrste.equals(((Vrsta_prijava)ob).getId_vrsta_prijava()) ;      
     } 
	
	

}
