package hr.hrcity.eredar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "grad")
public class Grad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_grad;
	
	@Column
	private long id_upravitelj;
	
	@Column(nullable = false)
    @NotEmpty
	private String naziv;
	
	@Column(nullable = false)
    @NotEmpty
	private String zupanija;

	public long getId_grad() {
		return id_grad;
	}

	public void setId_grad(long id_grad) {
		this.id_grad = id_grad;
	}

	public long getId_upravitelj() {
		return id_upravitelj;
	}

	public void setId_upravitelj(long id_upravitelj) {
		this.id_upravitelj = id_upravitelj;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getZupanija() {
		return zupanija;
	}

	public void setZupanija(String zupanija) {
		this.zupanija = zupanija;
	}

	@Override
	public String toString() {
		return "grad [id_grad=" + id_grad + ", id_upravitelj=" + id_upravitelj + ", naziv=" + naziv + ", zupanija="
				+ zupanija + "]";
	}
	
	public boolean equals(Object ob){  
        if(this==ob)          
             return true;  
        if(!(ob instanceof Grad))  
             return false;  
         //assume getter method in MyClass and this class has private variable myName, herName  
         return naziv.equals(((Grad)ob).getId_grad()) ;      
     } 
	
}

