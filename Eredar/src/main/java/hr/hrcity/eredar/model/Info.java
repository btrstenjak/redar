package hr.hrcity.eredar.model;

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
@Table(name = "info")
public class Info {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_info;
	
	@Column
	private long id_korisnik;
	
	@Column
	private int vrsta;
	
	@Column
	private int status;
	
	@Column
	private int id_upravitelj;
	
	@Column(nullable = false)
    @NotEmpty
	private String naslov;
	
	@Column(nullable = false)
    @NotEmpty
	private String poruka;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date datum;

	public long getId_info() {
		return id_info;
	}

	public void setId_info(long id_info) {
		this.id_info = id_info;
	}

	public long getId_korisnik() {
		return id_korisnik;
	}

	public void setId_korisnik(long id_korisnik) {
		this.id_korisnik = id_korisnik;
	}

	public int getVrsta() {
		return vrsta;
	}

	public void setVrsta(int vrsta) {
		this.vrsta = vrsta;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getId_upravitelj() {
		return id_upravitelj;
	}

	public void setId_upravitelj(int id_upravitelj) {
		this.id_upravitelj = id_upravitelj;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getPoruka() {
		return poruka;
	}

	public void setPoruka(String poruka) {
		this.poruka = poruka;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	@Override
	public String toString() {
		return "Info [id_info=" + id_info + ", id_korisnik=" + id_korisnik + ", vrsta=" + vrsta + ", status=" + status
				+ ", id_upravitelj=" + id_upravitelj + ", naslov=" + naslov + ", poruka=" + poruka + ", datum=" + datum
				+ "]";
	}

	

	
}
