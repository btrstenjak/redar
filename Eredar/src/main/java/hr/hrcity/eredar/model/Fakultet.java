package hr.hrcity.eredar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "fakultet")
public class Fakultet {
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
    @NotEmpty
    private String naziv;
    
    @Column(nullable = false)
    @NotEmpty
    private String studij;
    
    
    @Column
	private int studenti;
    
    @Column
   	private int sistem;
    
    
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNaziv() {
		return naziv;
	}



	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}



	public String getStudij() {
		return studij;
	}



	public void setStudij(String studij) {
		this.studij = studij;
	}



	public int getStudenti() {
		return studenti;
	}



	public void setStudenti(int studenti) {
		this.studenti = studenti;
	}



	public int getSistem() {
		return sistem;
	}



	public void setSistem(int sistem) {
		this.sistem = sistem;
	}



	@Override
	public String toString() {
		return "Fakultet [id=" + id + ", naziv=" + naziv + ", studij=" + studij + ", studenti=" + studenti + ", sistem="
				+ sistem + "]";
	}


}
