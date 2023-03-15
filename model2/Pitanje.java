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
@Table(name = "pitanje")
public class Pitanje {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_pitanje;
	
	@Column
	private long id_grad;
	
	@Column
	private long id_korisnik;
	
	@Column
	private int id_upravitelj;
	
	@Column
	private int status_prijave;
	
	@Column
	private int id_zaposlenika;
	
	@Column
	private int vidljivost;
	

	@Column(nullable = false)
    @NotEmpty
	private String adresa;
	
	@Column(nullable = false)
    @NotEmpty
	private String naziv_grad;
	
	@Column(nullable = false)
    @NotEmpty
	private String napomena;
	
	@Column(nullable = false)
    @NotEmpty
	private String naslov;
	
	@Column(nullable = false)
    @NotEmpty
	private String odgovor;
	
	
	@Column
	private int kvota;
	
	@Column
	private LocalDateTime zaprimljena;
	
	@Column
	private LocalDateTime zavrsena;

}
