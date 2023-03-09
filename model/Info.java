package hr.hrcity.eredar.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


import java.time.LocalDateTime;

@Entity
@Table(name = "info")
public class Info {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_info;
	
	@Column
	private integer id_upravitelj;
	
	@Column
	private integer vrsta;
	
	@Column
	private integer status;
	
	@Column
	private long id_korisnik;
	
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

	public void setId_upravitelj(integer id_upravitelj) {
		this.id_upravitelj = id_upravitelj;
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

	public long getId_korisnik() {
		return id_korisnik;
	}

	public void setId_korisnik(long id_korisnik) {
		this.id_korisnik = id_korisnik;
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
		return "Info [id_info=" + id_info + ", id_upravitelj=" + id_upravitelj + ", vrsta=" + vrsta + ", status="
				+ status + ", id_korisnik=" + id_korisnik + ", datum=" + datum + ", naslov=" + naslov + ", poruka="
				+ poruka + "]";
	}
		public boolean equals(Object ob){  
	        if(this==ob)          
	             return true;  
	        if(!(ob instanceof Grad))  
	             return false;  
	         //assume getter method in MyClass and this class has private variable myName, herName  
	         return naslov.equals(((Info)ob).getId_info()) ;      
	}
	
	
}
