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
@Table(name = "nalog")
public class Nalog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_nalog;
	
	@Column
	private Integer id_upravitelj;
	
	
	@Column
	private long id_prijava;
	
	@Column
	private long id_korisnik;
	
	@Column
	private Integer id_status_naloga;
	
	@Column
	private long poslano;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date datum_naloga;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date datum_slanja;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date datum_zatvaranja;
	
	@Column(nullable = false)
    @NotEmpty
	private String naslov;
	
	@Column(nullable = false)
    @NotEmpty
	private String oznaka_broj;
	
	@Column(nullable = false)
    @NotEmpty
	private String tekst_naslova;
	
	@Column(nullable = false)
    @NotEmpty
	private String email;
	
	@Column(nullable = false)
    @NotEmpty
	private String dokument;
	
	@Column(nullable = false)
    @NotEmpty
	private String url_dokumenta;
	
	@Column(nullable = false)
    @NotEmpty
	private String potpis;
	
	@Column(nullable = false)
    @NotEmpty
	private String pozicija;

	public long getId_nalog() {
		return id_nalog;
	}

	public void setId_nalog(long id_nalog) {
		this.id_nalog = id_nalog;
	}

	public Integer getId_upravitelj() {
		return id_upravitelj;
	}

	public void setId_upravitelj(Integer id_upravitelj) {
		this.id_upravitelj = id_upravitelj;
	}

	public long getId_prijava() {
		return id_prijava;
	}

	public void setId_prijava(long id_prijava) {
		this.id_prijava = id_prijava;
	}

	public long getId_korisnik() {
		return id_korisnik;
	}

	public void setId_korisnik(long id_korisnik) {
		this.id_korisnik = id_korisnik;
	}

	public Integer getId_status_naloga() {
		return id_status_naloga;
	}

	public void setId_status_naloga(Integer id_status_naloga) {
		this.id_status_naloga = id_status_naloga;
	}

	public long getPoslano() {
		return poslano;
	}

	public void setPoslano(long poslano) {
		this.poslano = poslano;
	}

	public Date getDatum_naloga() {
		return datum_naloga;
	}

	public void setDatum_naloga(Date datum_naloga) {
		this.datum_naloga = datum_naloga;
	}

	public Date getDatum_slanja() {
		return datum_slanja;
	}

	public void setDatum_slanja(Date datum_slanja) {
		this.datum_slanja = datum_slanja;
	}

	public Date getDatum_zatvaranja() {
		return datum_zatvaranja;
	}

	public void setDatum_zatvaranja(Date datum_zatvaranja) {
		this.datum_zatvaranja = datum_zatvaranja;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getOznaka_broj() {
		return oznaka_broj;
	}

	public void setOznaka_broj(String oznaka_broj) {
		this.oznaka_broj = oznaka_broj;
	}

	public String getTekst_naslova() {
		return tekst_naslova;
	}

	public void setTekst_naslova(String tekst_naslova) {
		this.tekst_naslova = tekst_naslova;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDokument() {
		return dokument;
	}

	public void setDokument(String dokument) {
		this.dokument = dokument;
	}

	public String getUrl_dokumenta() {
		return url_dokumenta;
	}

	public void setUrl_dokumenta(String url_dokumenta) {
		this.url_dokumenta = url_dokumenta;
	}

	public String getPotpis() {
		return potpis;
	}

	public void setPotpis(String potpis) {
		this.potpis = potpis;
	}

	public String getPozicija() {
		return pozicija;
	}

	public void setPozicija(String pozicija) {
		this.pozicija = pozicija;
	}

	@Override
	public String toString() {
		return "Nalog [id_nalog=" + id_nalog + ", id_upravitelj=" + id_upravitelj + ", id_prijava=" + id_prijava
				+ ", id_korisnik=" + id_korisnik + ", id_status_naloga=" + id_status_naloga + ", poslano=" + poslano
				+ ", datum_naloga=" + datum_naloga + ", datum_slanja=" + datum_slanja + ", datum_zatvaranja="
				+ datum_zatvaranja + ", naslov=" + naslov + ", oznaka_broj=" + oznaka_broj + ", tekst_naslova="
				+ tekst_naslova + ", email=" + email + ", dokument=" + dokument + ", url_dokumenta=" + url_dokumenta
				+ ", potpis=" + potpis + ", pozicija=" + pozicija + "]";
	}
	
	
	public boolean equals(Object ob){  
        if(this==ob)          
             return true;  
        if(!(ob instanceof Grad))  
             return false;  
         //assume getter method in MyClass and this class has private variable myName, herName  
         return naslov.equals(((Nalog)ob).getId_nalog()) ;      
     } 
	
	

}

