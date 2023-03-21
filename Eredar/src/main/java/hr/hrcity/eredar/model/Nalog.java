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
@Table(name = "nalog")
public class Nalog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_nalog;
	
	@Column
	private int id_upravitelj;
	
	@Column
	private long id_prijava;
	
	@Column
	private Byte poslano;
	
	
	
	@Column
	private int id_status_naloga;
	
	@Column
	private long id_korisnik;
	
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
	private String osoba;
	
	@Column(nullable = false)
	@NotEmpty
	private String email;
	
	@Column(nullable = false)
	@NotEmpty
	private String dokument;
	
	@Column(nullable = false)
	@NotEmpty
	private String url_dokument;
	
	@Column(nullable = false)
	@NotEmpty
	private String potpis;
	
	@Column
	private long pozicija;
	
	
	
	@Column
	private LocalDateTime datum_slanja;
	
	
	@Column
	private LocalDateTime datum_naloga;
	
	@Column
	private LocalDateTime datum_zatvaranja;

	
	
	public long getId_nalog() {
		return id_nalog;
	}



	public void setId_nalog(long id_nalog) {
		this.id_nalog = id_nalog;
	}



	public int getid_upravitelj() {
		return id_upravitelj;
	}



	public void setid_upravitelj(int id_upravitelj) {
		this.id_upravitelj = id_upravitelj;
	}



	public long getId_prijava() {
		return id_prijava;
	}



	public void setId_prijava(long id_prijava) {
		this.id_prijava = id_prijava;
	}



	public Byte getPoslano() {
		return poslano;
	}



	public void setPoslano(Byte poslano) {
		this.poslano = poslano;
	}



	public int getId_status_naloga() {
		return id_status_naloga;
	}



	public void setId_status_naloga(int id_status_naloga) {
		this.id_status_naloga = id_status_naloga;
	}



	public long getId_korisnik() {
		return id_korisnik;
	}



	public void setId_korisnik(long id_korisnik) {
		this.id_korisnik = id_korisnik;
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



	public String getOsoba() {
		return osoba;
	}



	public void setOsoba(String osoba) {
		this.osoba = osoba;
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



	public String getUrl_dokument() {
		return url_dokument;
	}



	public void setUrl_dokument(String url_dokument) {
		this.url_dokument = url_dokument;
	}



	public String getPotpis() {
		return potpis;
	}



	public void setPotpis(String potpis) {
		this.potpis = potpis;
	}



	public long getPozicija() {
		return pozicija;
	}



	public void setPozicija(long pozicija) {
		this.pozicija = pozicija;
	}



	


	public LocalDateTime getDatum_slanja() {
		return datum_slanja;
	}



	public void setDatum_slanja(LocalDateTime datum_slanja) {
		this.datum_slanja = datum_slanja;
	}




	public LocalDateTime getDatum_naloga() {
		return datum_naloga;
	}



	public void setDatum_naloga(LocalDateTime datum_naloga) {
		this.datum_naloga = datum_naloga;
	}



	public LocalDateTime getDatum_zatvaranja() {
		return datum_zatvaranja;
	}



	public void setDatum_zatvaranja(LocalDateTime datum_zatvaranja) {
		this.datum_zatvaranja = datum_zatvaranja;
	}



	
	@Override
	public String toString() {
		return "Nalog [id_nalog=" + id_nalog + ", id_upravitelj=" + id_upravitelj + ", id_prijava=" + id_prijava
				+ ", poslano=" + poslano + ", id_status_naloga=" + id_status_naloga + ", id_korisnik=" + id_korisnik
				+ ", naslov=" + naslov + ", oznaka_broj=" + oznaka_broj + ", tekst_naslova=" + tekst_naslova
				+ ", osoba=" + osoba + ", email=" + email + ", dokument=" + dokument + ", url_dokument=" + url_dokument
				+ ", potpis=" + potpis + ", pozicija=" + pozicija + ", url_dokumenta=" + ", datum_slanja=" + datum_slanja 
				+ ", datum_naloga="
				+ datum_naloga + ", datum_zatvaranja=" + datum_zatvaranja + "]";
	}



	public boolean equals(Object ob){  
        if(this==ob)          
             return true;  
        if(!(ob instanceof Nalog))  
             return false;  
         //assume getter method in MyClass and this class has private variable myName, herName  
         return naslov.equals(((Nalog)ob).getId_nalog()) ;      
     } 
	
	
}
