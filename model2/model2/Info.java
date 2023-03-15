package hr.hrcity.eredar.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


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
	private LocalDateTime datum;

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

	public LocalDateTime getDatum() {
		return datum;
	}

	public void setDatum(LocalDateTime datum) {
		this.datum = datum;
	}

	@Override
	public String toString() {
		return "Info [id_info=" + id_info + ", id_korisnik=" + id_korisnik + ", vrsta=" + vrsta + ", status=" + status
				+ ", id_upravitelj=" + id_upravitelj + ", naslov=" + naslov + ", poruka=" + poruka + ", datum=" + datum
				+ "]";
	}

	
	public boolean equals(Object ob){  
        if(this==ob)          
             return true;  
        if(!(ob instanceof Info))  
             return false;  
         //assume getter method in MyClass and this class has private variable myName, herName  
         return naslov.equals(((Info)ob).getId_info()) ;      
     } 
	
}
