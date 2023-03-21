package hr.hrcity.eredar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "oglas")
public class Oglasi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_oglas;
	
	@Column
	private int vidljiv;
	
	@Column(nullable = false)
	@NotEmpty
	private String tekst_1;


	@Column(nullable = false)
	@NotEmpty
	private String tekst_2;
	
	@Column(nullable = false)
	@NotEmpty
	private String link;

	public long getId_oglas() {
		return id_oglas;
	}

	public void setId_oglas(long id_oglas) {
		this.id_oglas = id_oglas;
	}

	public int getVidljiv() {
		return vidljiv;
	}

	public void setVidljiv(int vidljiv) {
		this.vidljiv = vidljiv;
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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "Oglasi [id_oglas=" + id_oglas + ", vidljiv=" + vidljiv + ", tekst_1=" + tekst_1 + ", tekst_2=" + tekst_2
				+ ", link=" + link + "]";
	}
	
	

}
