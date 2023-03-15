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
@Table(name = "upravitelj")
public class Upravitelj {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_upravitelj;
	
	@Column
	private Integer opcina_grad;
	
	@Column
	private Integer slanje_prijave;
	
	@Column
	private Integer aktivan;
	

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
	private String aktivacija;
	
	@Column(nullable = false)
    @NotEmpty
	private String email_prijave;
	
	@Column(nullable = false)
    @NotEmpty
	private String web;
	
	@Column(nullable = false)
    @NotEmpty
	private String grb;
	
	@Column(nullable = false)
    @NotEmpty
	private String nazivOdjela;
	
	@Column(nullable = false)
    @NotEmpty
	private String nazivGrada;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date aktivacija_datum;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date licenca;

	public Integer getId_upravitelj() {
		return id_upravitelj;
	}

	public void setId_upravitelj(Integer id_upravitelj) {
		this.id_upravitelj = id_upravitelj;
	}

	public Integer getOpcina_grad() {
		return opcina_grad;
	}

	public void setOpcina_grad(Integer opcina_grad) {
		this.opcina_grad = opcina_grad;
	}

	public Integer getSlanje_prijave() {
		return slanje_prijave;
	}

	public void setSlanje_prijave(Integer slanje_prijave) {
		this.slanje_prijave = slanje_prijave;
	}

	public Integer getAktivan() {
		return aktivan;
	}

	public void setAktivan(Integer aktivan) {
		this.aktivan = aktivan;
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

	public Date getAktivacija_datum() {
		return aktivacija_datum;
	}

	public void setAktivacija_datum(Date aktivacija_datum) {
		this.aktivacija_datum = aktivacija_datum;
	}
	
	public Date getLicenca() {
		return aktivacija_datum;
	}

	public void setLicenca(Date aktivacija_datum) {
		this.aktivacija_datum = aktivacija_datum;
	}

	@Override
	public String toString() {
		return "Upravitelj [id_upravitelj=" + id_upravitelj + ", opcina_grad=" + opcina_grad + ", slanje_prijave="
				+ slanje_prijave + ", aktivan=" + aktivan + ", ime_prezime=" + ime_prezime + ", email=" + email
				+ ", lozinka=" + lozinka + ", aktivacija=" + aktivacija + ", email_prijave=" + email_prijave + ", web="
				+ web + ", grb=" + grb + ", nazivOdjela=" + nazivOdjela + ", nazivGrada=" + nazivGrada
				+ ", aktivacija_datum=" + aktivacija_datum + "]";
	}
	
	
	public boolean equals(Object ob){  
        if(this==ob)          
             return true;  
        if(!(ob instanceof Upravitelj))  
             return false;  
         //assume getter method in MyClass and this class has private variable myName, herName  
         return ime_prezime.equals(((Upravitelj)ob).getId_upravitelj()) ;      
     } 
	
}
