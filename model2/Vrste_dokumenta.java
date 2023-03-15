package hr.hrcity.eredar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "vrste_dokumenata")
public class Vrste_dokumenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_vrsta_dokumenta;
	
	@Column(nullable = false)
    @NotEmpty
	private String naziv_dokumenta;

	
	
	public int getId_vrsta_dokumenta() {
		return id_vrsta_dokumenta;
	}



	public void setId_vrsta_dokumenta(int id_vrsta_dokumenta) {
		this.id_vrsta_dokumenta = id_vrsta_dokumenta;
	}



	public String getNaziv_dokumenta() {
		return naziv_dokumenta;
	}



	public void setNaziv_dokumenta(String naziv_dokumenta) {
		this.naziv_dokumenta = naziv_dokumenta;
	}



	
	
	@Override
	public String toString() {
		return "Vrste_dokumenta [id_vrsta_dokumenta=" + id_vrsta_dokumenta + ", naziv_dokumenta=" + naziv_dokumenta
				+ "]";
	}



	public boolean equals(Object ob){  
        if(this==ob)          
             return true;  
        if(!(ob instanceof Vrste_dokumenta))  
             return false;  
         //assume getter method in MyClass and this class has private variable myName, herName  
         return naziv_dokumenta.equals(((Vrste_dokumenta)ob).getId_vrsta_dokumenta()) ;      
     } 

}
