package hr.hrcity.eredar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import java.util.Date;


@Entity
@Table(name = "info_komunalni")
public class Info_komunalni {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_info;
	
	
	@Column
	private long id_upravitelj;
	
	@Column
	private integer id_zgrada;
	
	@Column
	private integer id_majstor;
	
	@Column
	private integer vrsta;
	
	@Column
	private integer status;

	@Column
	private integer vrsta_majstora;
	
	
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

	public long getId_upravitelj() {
		return id_upravitelj;
	}

	public void setId_upravitelj(long id_upravitelj) {
		this.id_upravitelj = id_upravitelj;
	}

	public integer getId_zgrada() {
		return id_zgrada;
	}

	public void setId_zgrada(integer id_zgrada) {
		this.id_zgrada = id_zgrada;
	}

	public integer getId_majstor() {
		return id_majstor;
	}

	public void setId_majstor(integer id_majstor) {
		this.id_majstor = id_majstor;
	}

	public integer getVrsta() {
		return vrsta;
	}

	public void setVrsta(integer vrsta) {
		this.vrsta = vrsta;
	}

	public integer getStatus() {
		return status;
	}

	public void setStatus(integer status) {
		this.status = status;
	}

	public integer getVrsta_majstora() {
		return vrsta_majstora;
	}

	public void setVrsta_majstora(integer vrsta_majstora) {
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
				+ ", id_majstor=" + id_majstor + ", vrsta=" + vrsta + ", status=" + status + ", vrsta_majstora="
				+ vrsta_majstora + ", datum=" + datum + ", naslov=" + naslov + ", poruka=" + poruka + "]";
	}
	
	public boolean equals(Object ob){  
        if(this==ob)          
             return true;  
        if(!(ob instanceof Grad))  
             return false;  
         //assume getter method in MyClass and this class has private variable myName, herName  
         return naslov.equals(((Info_komunalni)ob).getId_info()) ;      
     } 

	
}
