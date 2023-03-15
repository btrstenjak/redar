package hr.hrcity.eredar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


 @Entity
 @Table(name = "error_log")
public class Error_log {
	 
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long id_error;
	 
	 @Column(nullable = false)
	 @NotEmpty
	 private String text;

	public long getId_error() {
		return id_error;
	}

	public void setId_error(long id_error) {
		this.id_error = id_error;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Error_log [id_error=" + id_error + ", text=" + text + "]";
	}
	 
	public boolean equals(Object ob){  
        if(this==ob)          
             return true;  
        if(!(ob instanceof Error_log))  
             return false;  
         //assume getter method in MyClass and this class has private variable myName, herName  
         return text.equals(((Error_log)ob).getId_error()) ;      
     } 
}
