package hr.hrcity.eredar.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "tiket")
public class Tiket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_tiket;
	
	
	@Column
	private long id_upit;
	
	@Column
	private long id_korisnik;
	
	@Column
	private int vrsta;
	
	@Column
	private int id_upravitelj;
	
	@Column
	private int status;
	
	@Column(nullable = false)
    @NotEmpty
	private String aktivacija;
	
	@Column(nullable = false)
    @NotEmpty
	private String pitanje;
	
	@Column(nullable = false)
    @NotEmpty
	private String odgovor;

	public long getId_tiket() {
		return id_tiket;
	}









	public void setId_tiket(long id_tiket) {
		this.id_tiket = id_tiket;
	}









	public long getId_upit() {
		return id_upit;
	}









	public void setId_upit(long id_upit) {
		this.id_upit = id_upit;
	}









	public long getId_korisnik() {
		return id_korisnik;
	}









	public void setId_korisnika(long id_korisnik) {
		this.id_korisnik = id_korisnik;
	}









	public int getVrsta() {
		return vrsta;
	}









	public void setVrsta(int vrsta) {
		this.vrsta = vrsta;
	}









	public int getId_upravitelj() {
		return id_upravitelj;
	}









	public void setId_upravitelj(int id_upravitelj) {
		this.id_upravitelj = id_upravitelj;
	}









	public int getStatus() {
		return status;
	}









	public void setStatus(int status) {
		this.status = status;
	}









	public String getAktivacija() {
		return aktivacija;
	}









	public void setAktivacija(String aktivacija) {
		this.aktivacija = aktivacija;
	}









	public String getPitanje() {
		return pitanje;
	}









	public void setPitanje(String pitanje) {
		this.pitanje = pitanje;
	}









	public String getOdgovor() {
		return odgovor;
	}









	public void setOdgovor(String odgovor) {
		this.odgovor = odgovor;
	}






	@Override
	public String toString() {
		return "Tiket [id_tiket=" + id_tiket + ", id_upit=" + id_upit + ", id_korisnika=" + id_korisnik + ", vrsta="
				+ vrsta + ", id_upravitelj=" + id_upravitelj + ", status=" + status + ", aktivacija=" + aktivacija
				+ ", pitanje=" + pitanje + ", odgovor=" + odgovor + "]";
	}

}
