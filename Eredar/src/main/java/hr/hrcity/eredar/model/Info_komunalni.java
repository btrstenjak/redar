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
@Table(name = "info_komunalni")
public class Info_komunalni {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_info;
	
	@Column
	private int id_upravitelj;
	
	@Column
	private int id_zgrada;
	

	@Column
	private int id_majstor;
	
	@Column
	private int status;
	
	@Column
	private int vrsta;
	
	@Column
	private int vrsta_majstora;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date datum;

	@Column(nullable = false)
    @NotEmpty
	private String naslov;
	
	@Column(nullable = false)
    @NotEmpty
	private String poruka;

	
	
	public long getId_info() {
		return id_info;
	}



	public void setId_info(long id_info) {
		this.id_info = id_info;
	}



	public int getId_upravitelj() {
		return id_upravitelj;
	}



	public void setId_upravitelj(int id_upravitelj) {
		this.id_upravitelj = id_upravitelj;
	}



	public int getId_zgrada() {
		return id_zgrada;
	}



	public void setId_zgrada(int id_zgrada) {
		this.id_zgrada = id_zgrada;
	}



	public int getId_majstor() {
		return id_majstor;
	}



	public void setId_majstor(int id_majstor) {
		this.id_majstor = id_majstor;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}



	public int getVrsta() {
		return vrsta;
	}



	public void setVrsta(int vrsta) {
		this.vrsta = vrsta;
	}



	public int getVrsta_majstora() {
		return vrsta_majstora;
	}



	public void setVrsta_majstora(int vrsta_majstora) {
		this.vrsta_majstora = vrsta_majstora;
	}



	public Date getDatum() {
		return datum;
	}



	public void setDatum(Date datum) {
		this.datum = datum;
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



	@Override
	public String toString() {
		return "Info_komunalni [id_info=" + id_info + ", id_upravitelj=" + id_upravitelj + ", id_zgrada=" + id_zgrada
				+ ", id_majstor=" + id_majstor + ", status=" + status + ", vrsta=" + vrsta + ", vrsta_majstora="
				+ vrsta_majstora + ", datum=" + datum + ", naslov=" + naslov + ", poruka=" + poruka + "]";
	}
 
}