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
@Table(name = "crna_lista")
public class Crna_lista {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_crna;
	
	@Column
    private int razlog;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date datum;
	
	
	@Column(nullable = false)
    @NotEmpty
    private String email;
	
	@Column(nullable = false)
    @NotEmpty
    private String mac;

	public int getId_crna() {
		return id_crna;
	}

	public void setId_crna(int id_crna) {
		this.id_crna = id_crna;
	}

	public int getRazlog() {
		return razlog;
	}

	public void setRazlog(int razlog) {
		this.razlog = razlog;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	@Override
	public String toString() {
		return "Crna_lista [id_crna=" + id_crna + ", razlog=" + razlog + ", datum=" + datum + ", email=" + email
				+ ", mac=" + mac + "]";
	}



         //assume getter method in MyClass and this class has private variable myName, herName  
	
	

}
