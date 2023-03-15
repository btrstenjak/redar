package hr.hrcity.eredar.model;

import java.sql.Date;

public class CommitClass {
	
	
	private int id;
	
	private int id_korisnik;
	
	private String naziv;
	
	private String korisnik;
	
	private Date vrijeme;
	
	private String opis;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_korisnik() {
		return id_korisnik;
	}

	public void setId_korisnik(int id_korisnik) {
		this.id_korisnik = id_korisnik;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(String korisnik) {
		this.korisnik = korisnik;
	}

	public Date getVrijeme() {
		return vrijeme;
	}

	public void setVrijeme(Date vrijeme) {
		this.vrijeme = vrijeme;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	
	
}
