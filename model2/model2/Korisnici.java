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
@Table(name = "korisnici")
public class Korisnici {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_korisnik;
	
	@Column
	private int id_upravitelj;
	
	@Column
	private long id_grad;
	
	
	@Column
	private int vrsta_korisnika;
	
	@Column
	private int aktivan;
	
	@Column
	private int salji_poruku;
	
	@Column
	private int logiran;
	
	@Column(nullable = false)
    @NotEmpty
	private String ime_prezime;
	
	@Column(nullable = false)
    @NotEmpty
	private String email;
	
	
	@Column(nullable = false)
    @NotEmpty
	private String lozinka;
	
	@Column(nullable = false)
    @NotEmpty
	private String opis;
	
	@Column(nullable = false)
    @NotEmpty
	private String aktivacijski_kljuc;
	
	@Column(nullable = false)
    @NotEmpty
	private String mac;
	
	@Column
	private LocalDateTime aktivacija_datum;
	
	
	@Column
	private LocalDateTime created_at;
	
	@Column
	private LocalDateTime updated_at;

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

	public long getId_grad() {
		return id_grad;
	}

	public void setId_grad(long id_grad) {
		this.id_grad = id_grad;
	}

	public int getVrsta_korisnika() {
		return vrsta_korisnika;
	}

	public void setVrsta_korisnika(int vrsta_korisnika) {
		this.vrsta_korisnika = vrsta_korisnika;
	}

	public int getAktivan() {
		return aktivan;
	}

	public void setAktivan(int aktivan) {
		this.aktivan = aktivan;
	}

	public int getSalji_poruku() {
		return salji_poruku;
	}

	public void setSalji_poruku(int salji_poruku) {
		this.salji_poruku = salji_poruku;
	}

	public int getLogiran() {
		return logiran;
	}

	public void setLogiran(int logiran) {
		this.logiran = logiran;
	}

	public String getIme_prezime() {
		return ime_prezime;
	}

	public void setIme_prezime(String ime_prezime) {
		this.ime_prezime = ime_prezime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getAktivacijski_kljuc() {
		return aktivacijski_kljuc;
	}

	public void setAktivacijski_kljuc(String aktivacijski_kljuc) {
		this.aktivacijski_kljuc = aktivacijski_kljuc;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public LocalDateTime getAktivacija_datum() {
		return aktivacija_datum;
	}

	public void setAktivacija_datum(LocalDateTime aktivacija_datum) {
		this.aktivacija_datum = aktivacija_datum;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}

	@Override
	public String toString() {
		return "Korisnici [id_korisnik=" + id_korisnik + ", id_upravitelj=" + id_upravitelj + ", id_grad=" + id_grad
				+ ", vrsta_korisnika=" + vrsta_korisnika + ", aktivan=" + aktivan + ", salji_poruku=" + salji_poruku
				+ ", logiran=" + logiran + ", ime_prezime=" + ime_prezime + ", email=" + email + ", lozinka=" + lozinka
				+ ", opis=" + opis + ", aktivacijski_kljuc=" + aktivacijski_kljuc + ", mac=" + mac
				+ ", aktivacija_datum=" + aktivacija_datum + ", created_at=" + created_at + ", updated_at=" + updated_at
				+ "]";
	}
	
	public boolean equals(Object ob){  
        if(this==ob)          
             return true;  
        if(!(ob instanceof Korisnici))  
             return false;  
         //assume getter method in MyClass and this class has private variable myName, herName  
         return ime_prezime.equals(((Korisnici)ob).getId_korisnik()) ;      
     } 
}
