package hr.hrcity.eredar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "status_naloga")
public class Status_naloga {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_status_naloga;
	
	@Column(nullable = false)
    @NotEmpty
	private String naziv_status;

	

	public long getId_status_naloga() {
		return id_status_naloga;
	}







	public void setId_status_naloga(long id_status_naloga) {
		this.id_status_naloga = id_status_naloga;
	}







	public String getNaziv_status() {
		return naziv_status;
	}







	public void setNaziv_status(String naziv_status) {
		this.naziv_status = naziv_status;
	}




	@Override
	public String toString() {
		return "Status_naloga [id_status_naloga=" + id_status_naloga + ", naziv_status=" + naziv_status + "]";
	}

}
