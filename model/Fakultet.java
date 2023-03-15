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
	private Integer id_fakultet;



	@Column (nullable = false)
	@NotEmpty 
	private String naziv;

	@Column (nullable = false)
	@NotEmpty 
	private String studij;

	@Column (nullable = false)
	@NotEmpty 
	private Integer studenti;

	@Column (nullable = false)
	@NotEmpty 
	private Integer sistem;

	public Integer getId_fakultet() {
		return id_fakultet;
	}
	public void setId_fakultet(Integer id_fakultet) {
		this.id_fakultet = id_fakultet;
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
	public long getStudenti() {
		return studenti;
	}

	public void setStuent(Integer studenti) {
		this.studenti = studenti;
	}

	public Integer getSistem() {
		return sistem;
	}

	public void setSistem(Integer sistem) {
		this.sistem = sistem;
	}

	@Override

	public String toString() {
		return "fakultet [id_fakultet=" + id_fakultet + ", naziv=" + naziv + 
				", studij=" + studij +", studenti=" + studenti + ", sistem" + sistem + "]";	
	}

	public boolean equals(Object ob) {

		if (this==ob)
			return true;
		if(!(ob instanceof Fakultet))
			return false;
		return naziv.equals(((Fakultet)ob).getId_fakultet()); 
	}



}