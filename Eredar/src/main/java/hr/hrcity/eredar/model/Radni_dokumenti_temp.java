package hr.hrcity.eredar.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "radni_dokumenti_temp")
public class Radni_dokumenti_temp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_predlozak;
	
	@Column
	private int id_upravitelj;
	
	@Column
	private int vrsta;

	
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
	private String naziv_predloska;
	
	@Column(nullable = false)
    @NotEmpty
	private String osoba;

	public long getId_predlozak() {
		return id_predlozak;
	}

	public void setId_predlozak(long id_predlozak) {
		this.id_predlozak = id_predlozak;
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

	public String getNaziv_predloska() {
		return naziv_predloska;
	}

	public void setNaziv_predloska(String naziv_predloska) {
		this.naziv_predloska = naziv_predloska;
	}

	public String getOsoba() {
		return osoba;
	}

	public void setOsoba(String osoba) {
		this.osoba = osoba;
	}

	@Override
	public String toString() {
		return "Radni_dokumenti_temp [id_predlozak=" + id_predlozak + ", id_upravitelj=" + id_upravitelj + ", vrsta="
				+ vrsta + ", obrazlozenje=" + obrazlozenje + ", tekst_1=" + tekst_1 + ", tekst_2=" + tekst_2
				+ ", pravoljek=" + pravoljek + ", potpis=" + potpis + ", dostaviti=" + dostaviti + ", klasa=" + klasa
				+ ", URB=" + URB + ", naziv_predloska=" + naziv_predloska + ", osoba=" + osoba + "]";
	}

}
