package hr.hrcity.eredar.model;

import java.security.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "arhiva")
public class Arhiva {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_arhiva;
	
	@Column(nullable = false)
    @NotEmpty
	private String naziv;
	
	@Column(nullable = false)
    @NotEmpty
	private String putanja;
	
	
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date datum;

	public long getId_arhiva() {
		return id_arhiva;
	}

	public void setId_arhiva(long id_arhiva) {
		this.id_arhiva = id_arhiva;
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

	
	
	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	@Override
	public String toString() {
		return "Arhiva [id_arhiva=" + id_arhiva + ", naziv=" + naziv + ", putanja=" + putanja + ", datum=" + datum
				+ "]";
	}

}
