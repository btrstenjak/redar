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
@Table(name = "upravitelji")
public class Upravitelji {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_upravitelj;
	
	@Column
	private short aktivan;
	
	@Column
	private short slanje_prijave;
	
	@Column
	private short opcina_grad;


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
	private String web;
	
	@Column(nullable = false)
    @NotEmpty
	private String grb;
	
	@Column(nullable = false)
    @NotEmpty
	private String aktivacija;
	
	@Column(nullable = false)
    @NotEmpty
	private String email_prijave;
	
	@Column(nullable = false)
    @NotEmpty
	private String nazivOdjela;
	
	@Column(nullable = false)
    @NotEmpty
	private String nazivGrada;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date licenca;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date aktivacija_datum;
	

	public int getId_upravitelj() {
		return id_upravitelj;
	}

	public void setId_upravitelj(int id_upravitelj) {
		this.id_upravitelj = id_upravitelj;
	}

	public short getAktivan() {
		return aktivan;
	}

	public void setAktivan(short aktivan) {
		this.aktivan = aktivan;
	}

	public short getSlanje_prijave() {
		return slanje_prijave;
	}

	public void setSlanje_prijave(short slanje_prijave) {
		this.slanje_prijave = slanje_prijave;
	}


	public short getOpcina_grad() {
		return opcina_grad;
	}


	public void setOpcina_grad(short opcina_grad) {
		this.opcina_grad = opcina_grad;
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



	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}



	public String getGrb() {
		return grb;
	}



	public void setGrb(String grb) {
		this.grb = grb;
	}


	public String getAktivacija() {
		return aktivacija;
	}



	public void setAktivacija(String aktivacija) {
		this.aktivacija = aktivacija;
	}

	public String getEmail_prijave() {
		return email_prijave;
	}





	public void setEmail_prijave(String email_prijave) {
		this.email_prijave = email_prijave;
	}





	public String getNazivOdjela() {
		return nazivOdjela;
	}




	public void setNazivOdjela(String nazivOdjela) {
		this.nazivOdjela = nazivOdjela;
	}





	public String getNazivGrada() {
		return nazivGrada;
	}



	public void setNazivGrada(String nazivGrada) {
		this.nazivGrada = nazivGrada;
	}





	public Date getLicenca() {
		return licenca;
	}

	public void setLicenca(Date licenca) {
		this.licenca = licenca;
	}




	public Date getAktivacija_datum() {
		return aktivacija_datum;
	}







	public void setAktivacija_datum(Date aktivacija_datum) {
		this.aktivacija_datum = aktivacija_datum;
	}



	
	@Override
	public String toString() {
		return "Upravitelj [id_upravitelj=" + id_upravitelj + ", aktivan=" + aktivan + ", slanje_prijave="
				+ slanje_prijave + ", opcina_grad=" + opcina_grad + ", ime_prezime=" + ime_prezime + ", email=" + email
				+ ", lozinka=" + lozinka + ", web=" + web + ", grb=" + grb + ", aktivacija=" + aktivacija
				+ ", email_prijave=" + email_prijave + ", nazivOdjela=" + nazivOdjela + ", nazivGrada=" + nazivGrada
				+ ", licenca=" + licenca + ", aktivacija_datum=" + aktivacija_datum + "]";
	}

}