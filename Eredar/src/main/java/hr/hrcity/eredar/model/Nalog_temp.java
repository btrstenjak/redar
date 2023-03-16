package hr.hrcity.eredar.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "nalog_temp")
public class Nalog_temp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_predlozak;
	
	@Column
	private Integer id_upravitelj;
	
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
	private String osoba;
	
	@Column(nullable = false)
    @NotEmpty
	private String potpis;
	
	@Column(nullable = false)
    @NotEmpty
	private String naziv_predloska;
	
	@Column(nullable = false)
    @NotEmpty
	private String tekst;

	public long getId_predlozak() {
		return id_predlozak;
	}

	public void setId_predlozak(long id_predlozak) {
		this.id_predlozak = id_predlozak;
	}

	public Integer getId_upravitelj() {
		return id_upravitelj;
	}

	public void setId_upravitelj(Integer id_upravitelj) {
		this.id_upravitelj = id_upravitelj;
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

	public String getOsoba() {
		return osoba;
	}

	public void setOsoba(String osoba) {
		this.osoba = osoba;
	}

	public String getPotpis() {
		return potpis;
	}

	public void setPotpis(String potpis) {
		this.potpis = potpis;
	}

	public String getNaziv_predloska() {
		return naziv_predloska;
	}

	public void setNaziv_predloska(String naziv_predloska) {
		this.naziv_predloska = naziv_predloska;
	}

	public String getTekst() {
		return tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	@Override
	public String toString() {
		return "Nalog_temp [id_predlozak=" + id_predlozak + ", id_upravitelj=" + id_upravitelj + ", naslov=" + naslov
				+ ", oznaka_broj=" + oznaka_broj + ", tekst_naslova=" + tekst_naslova + ", email=" + email + ", osoba="
				+ osoba + ", potpis=" + potpis + ", naziv_predloska=" + naziv_predloska + ", tekst=" + tekst + "]";
	}


	
	public boolean equals(Object ob){  
        if(this==ob)          
             return true;  
        if(!(ob instanceof Nalog_temp))  
             return false;  
         //assume getter method in MyClass and this class has private variable myName, herName  
         return naslov.equals(((Nalog_temp)ob).getId_predlozak()) ;      
     } 
}

