package hr.hrcity.eredar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


 @Entity
 @Table(name = "error_log")
public class Error_log {
	 
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long id_error;
	 
	 @Column(nullable = false)
	 @NotEmpty
	 private String opis;

	public long getId_error() {
		return id_error;
	}

	public void setId_error(long id_error) {
		this.id_error = id_error;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	@Override
	public String toString() {
		return "Error_log [id_error=" + id_error + ", opis=" + opis + "]";
	}
	 
          
}
