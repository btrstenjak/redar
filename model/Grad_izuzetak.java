package hr.hrcity.eredar.model;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;




@Entity
@Table(name = "grad_izuzetak")
public class Grad_izuzetak {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_grad_izuzetak;
	
	@Column
	private long id_grad;
	
	
	public long getId_grad_izuzetak() {
		return id_grad_izuzetak;
	}

	public void setId_grad_izuzetak(long id_grad_izuzetak) {
		this.id_grad_izuzetak = id_grad_izuzetak;
	}

	public long getId_grad() {
		return id_grad;
	}

	public void setId_grad(long id_grad) {
		this.id_grad = id_grad;
	}

	

	@Override
	public String toString() {
		return "Grad_izuzetak [id_grad_izuzetak=" + id_grad_izuzetak + ", id_grad=" + id_grad + "]";
	}

	 //assume getter method in MyClass and this class has private variable myName, herName  

	
	
	

}


