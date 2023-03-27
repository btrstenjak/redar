package hr.hrcity.eredar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "vrste_prijava")
public class Vrste_prijava {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_vrsta;
	
	@Column(nullable = false)
    @NotEmpty
	private String naziv_vrste;


	public int getId_vrsta() {
		return id_vrsta;
	}


	public void setId_vrsta(int id_vrsta) {
		this.id_vrsta = id_vrsta;
	}


	public String getNaziv_vrste() {
		return naziv_vrste;
	}


	public void setNaziv_vrste(String naziv_vrste) {
		this.naziv_vrste = naziv_vrste;
	}



	
	@Override
	public String toString() {
		return "Vrste_prijava [id_vrsta=" + id_vrsta + ", naziv_vrste=" + naziv_vrste + "]";
	}


	
}
