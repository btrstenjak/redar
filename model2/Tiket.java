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
	private long id_korisnika;
	
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









	public long getId_korisnika() {
		return id_korisnika;
	}









	public void setId_korisnika(long id_korisnika) {
		this.id_korisnika = id_korisnika;
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
		return "Tiket [id_tiket=" + id_tiket + ", id_upit=" + id_upit + ", id_korisnika=" + id_korisnika + ", vrsta="
				+ vrsta + ", id_upravitelj=" + id_upravitelj + ", status=" + status + ", aktivacija=" + aktivacija
				+ ", pitanje=" + pitanje + ", odgovor=" + odgovor + "]";
	}



	public boolean equals(Object ob){  
        if(this==ob)          
             return true;  
        if(!(ob instanceof Tiket))  
             return false;  
         //assume getter method in MyClass and this class has private variable myName, herName  
         return pitanje.equals(((Tiket)ob).getId_tiket()) ;      
     } 
}
