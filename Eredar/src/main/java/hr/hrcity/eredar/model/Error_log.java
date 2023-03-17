	package hr.hrcity.eredar.model;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;
	import javax.validation.constraints.NotEmpty;


	//// @Entity: This annotation marks the class as an entity that can 
	//be mapped to a database table.
	@Entity

	///@Table(name = "error_log"): This annotation specifies the
	// name of the database table that this entity maps to.
	@Table(name = "error_log")
	public class Error_log {

		@Id

		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id_error;

		@Column
		@NotEmpty
		private String opis;


		public long getId_error() {
			return id_error;
		}
	//his is a setter method for the id_grad field.
		public void setId_error(long id_error) {
			this.id_error = id_error;
		}

		public String getOpis() {
			return opis;
		}

		public void setOpis(String opis) {
			this.opis = opis;
		}

		@Override

		public String toString() {
			return "error id [id_error=" + id_error + ", opis"+ opis + "]";
		} 

		public boolean equals(Object ob){  
	        if(this==ob)          
	             return true;  
	        if(!(ob instanceof Error_log))  
	             return false;  
	         //********assume getter method in MyClass and this class has private variable myName, herName  
	         return opis.equals(((Error_log)ob).getId_error()) ;      
	     } 

	}



