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
@Table(name = "radni_dokumenti")
public class Radni_dokumenti {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_radni_dokument;
	
	@Column
	private int id_upravitelj;
	
	@Column
	private int vrsta;


	@Column(nullable = false)
    @NotEmpty
	private String naslov_dokumenta;
	
	@Column(nullable = false)
    @NotEmpty
	private String obrazlozenje;
	
	@Column(nullable = false)
    @NotEmpty
	private String tekst_1;
	
	@Column(nullable = false)
    @NotEmpty
	private String tekst_2;
	
	@Column(nullable = false)
    @NotEmpty
	private String pravoljek;
	
	@Column(nullable = false)
    @NotEmpty
	private String potpis;
	
	@Column(nullable = false)
    @NotEmpty
	private String dostaviti;
	
	@Column(nullable = false)
    @NotEmpty
	private String klasa;
	
	@Column(nullable = false)
    @NotEmpty
	private String URB;
	
	@Column(nullable = false)
    @NotEmpty
	private String url_dokument;
	
	@Column(nullable = false)
    @NotEmpty
	private String osoba;
	
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date datum_sluzbeno;


	public long getId_radni_dokument() {
		return id_radni_dokument;
	}


	public void setId_radni_dokument(long id_radni_dokument) {
		this.id_radni_dokument = id_radni_dokument;
	}


	public int getId_upravitelj() {
		return id_upravitelj;
	}


	public void setId_upravitelj(int id_upravitelj) {
		this.id_upravitelj = id_upravitelj;
	}


	public int getVrsta() {
		return vrsta;
	}


	public void setVrsta(int vrsta) {
		this.vrsta = vrsta;
	}


	public String getNaslov_dokumenta() {
		return naslov_dokumenta;
	}


	public void setNaslov_dokumenta(String naslov_dokumenta) {
		this.naslov_dokumenta = naslov_dokumenta;
	}


	public String getObrazlozenje() {
		return obrazlozenje;
	}


	public void setObrazlozenje(String obrazlozenje) {
		this.obrazlozenje = obrazlozenje;
	}


	public String getTekst_1() {
		return tekst_1;
	}


	public void setTekst_1(String tekst_1) {
		this.tekst_1 = tekst_1;
	}


	public String getTekst_2() {
		return tekst_2;
	}


	public void setTekst_2(String tekst_2) {
		this.tekst_2 = tekst_2;
	}


	public String getPravoljek() {
		return pravoljek;
	}


	public void setPravoljek(String pravoljek) {
		this.pravoljek = pravoljek;
	}


	public String getPotpis() {
		return potpis;
	}


	public void setPotpis(String potpis) {
		this.potpis = potpis;
	}


	public String getDostaviti() {
		return dostaviti;
	}


	public void setDostaviti(String dostaviti) {
		this.dostaviti = dostaviti;
	}


	public String getKlasa() {
		return klasa;
	}


	public void setKlasa(String klasa) {
		this.klasa = klasa;
	}


	public String getURB() {
		return URB;
	}


	public void setURB(String uRB) {
		URB = uRB;
	}


	public String getUrl_dokument() {
		return url_dokument;
	}


	public void setUrl_dokument(String url_dokument) {
		this.url_dokument = url_dokument;
	}


	public String getOsoba() {
		return osoba;
	}


	public void setOsoba(String osoba) {
		this.osoba = osoba;
	}


	public Date getDatum_sluzbeno() {
		return datum_sluzbeno;
	}


	public void setDatum_sluzbeno(Date datum_sluzbeno) {
		this.datum_sluzbeno = datum_sluzbeno;
	}


	@Override
	public String toString() {
		return "Radni_dokumenti [id_radni_dokument=" + id_radni_dokument + ", id_upravitelj=" + id_upravitelj
				+ ", vrsta=" + vrsta + ", naslov_dokumenta=" + naslov_dokumenta + ", obrazlozenje=" + obrazlozenje
				+ ", tekst_1=" + tekst_1 + ", tekst_2=" + tekst_2 + ", pravoljek=" + pravoljek + ", potpis=" + potpis
				+ ", dostaviti=" + dostaviti + ", klasa=" + klasa + ", URB=" + URB + ", url_dokument=" + url_dokument
				+ ", osoba=" + osoba + ", datum_sluzbeno=" + datum_sluzbeno + "]";
	}
	
	public boolean equals(Object ob){  
        if(this==ob)          
             return true;  
        if(!(ob instanceof Radni_dokumenti))  
             return false;  
         //assume getter method in MyClass and this class has private variable myName, herName  
         return naslov_dokumenta.equals(((Radni_dokumenti)ob).getId_radni_dokument()) ;      
     } 
	
}
