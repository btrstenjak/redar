package hr.hrcity.eredar.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "prijava")
public class Prijava {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_prijava;
	
	@Column
	private long id_grad;
	
	@Column
	private long id_korisnik;
	
	@Column
	private int id_upravitelj;
	
	
	@Column
	private int id_status_prijave;
	
	@Column
	private int id_vrsta_prijave;
	
	@Column
	private int id_zaposlenika;
	
	@Column(nullable = false)
    @NotEmpty
	private String latitude;
	
	@Column(nullable = false)
    @NotEmpty
	private String longitude;
	
	
	@Column(nullable = false)
    @NotEmpty
	private String slika;
	
	@Column(nullable = false)
    @NotEmpty
	private String url_slika;
	
	@Column(nullable = false)
    @NotEmpty
	private String slika_sirina;
	
	@Column(nullable = false)
    @NotEmpty
	private String slika_visina;
	
	
	@Column(nullable = false)
    @NotEmpty
	private String adresa;
	
	@Column(nullable = false)
    @NotEmpty
	private String napomena;
	
	@Column(nullable = false)
    @NotEmpty
	private String naslov;
	
	@Column(nullable = false)
    @NotEmpty
	private String odgovor;
	
	@Column(nullable = false)
    @NotEmpty      
	private String proslijedena;
	
	@Column(nullable = false)
    @NotEmpty
	private String vrsta_naziv;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date zaprimljena;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date zavrsena;

	public long getId_prijava() {
		return id_prijava;
	}

	public void setId_prijava(long id_prijava) {
		this.id_prijava = id_prijava;
	}

	public long getId_grad() {
		return id_grad;
	}

	public void setId_grad(long id_grad) {
		this.id_grad = id_grad;
	}

	public long getId_korisnik() {
		return id_korisnik;
	}

	public void setId_korisnik(long id_korisnik) {
		this.id_korisnik = id_korisnik;
	}

	public int getId_upravitelj() {
		return id_upravitelj;
	}

	public void setId_upravitelj(int id_upravitelj) {
		this.id_upravitelj = id_upravitelj;
	}

	public int getId_status_prijave() {
		return id_status_prijave;
	}

	public void setId_status_prijave(int id_status_prijave) {
		this.id_status_prijave = id_status_prijave;
	}

	public int getId_vrsta_prijave() {
		return id_vrsta_prijave;
	}

	public void setId_vrsta_prijave(int id_vrsta_prijave) {
		this.id_vrsta_prijave = id_vrsta_prijave;
	}

	public int getId_zaposlenika() {
		return id_zaposlenika;
	}

	public void setId_zaposlenika(int id_zaposlenika) {
		this.id_zaposlenika = id_zaposlenika;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getSlika() {
		return slika;
	}

	public void setSlika(String slika) {
		this.slika = slika;
	}

	public String getUrl_slika() {
		return url_slika;
	}

	public void setUrl_slika(String url_slika) {
		this.url_slika = url_slika;
	}

	public String getSlika_sirina() {
		return slika_sirina;
	}

	public void setSlika_sirina(String slika_sirina) {
		this.slika_sirina = slika_sirina;
	}

	public String getSlika_visina() {
		return slika_visina;
	}

	public void setSlika_visina(String slika_visina) {
		this.slika_visina = slika_visina;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getNapomena() {
		return napomena;
	}

	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getOdgovor() {
		return odgovor;
	}

	public void setOdgovor(String odgovor) {
		this.odgovor = odgovor;
	}

	public String getProslijedena() {
		return proslijedena;
	}

	public void setProslijedena(String proslijedena) {
		this.proslijedena = proslijedena;
	}

	public String getVrsta_naziv() {
		return vrsta_naziv;
	}

	public void setVrsta_naziv(String vrsta_naziv) {
		this.vrsta_naziv = vrsta_naziv;
	}

	public Date getZaprimljena() {
		return zaprimljena;
	}

	public void setZaprimljena(Date zaprimljena) {
		this.zaprimljena = zaprimljena;
	}

	public Date getZavrsena() {
		return zavrsena;
	}

	public void setZavrsena(Date zavrsena) {
		this.zavrsena = zavrsena;
	}

	@Override
	public String toString() {
		return "Prijava [id_prijava=" + id_prijava + ", id_grad=" + id_grad + ", id_korisnik=" + id_korisnik
				+ ", id_upravitelj=" + id_upravitelj + ", id_status_prijave=" + id_status_prijave + ", id_vrsta_prijave="
				+ id_vrsta_prijave + ", id_zaposlenika=" + id_zaposlenika + ", latitude=" + latitude + ", longitude="
				+ longitude + ", slika=" + slika + ", url_slika=" + url_slika + ", slika_sirina=" + slika_sirina
				+ ", slika_visina=" + slika_visina + ", adresa=" + adresa + ", napomena=" + napomena + ", naslov="
				+ naslov + ", odgovor=" + odgovor + ", proslijedena=" + proslijedena + ", vrsta_naziv=" + vrsta_naziv
				+ ", zaprimljena=" + zaprimljena + ", zavrsena=" + zavrsena + "]";
	}
 
}
