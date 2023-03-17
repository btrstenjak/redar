package hr.hrcity.eredar.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hr.hrcity.eredar.model.Vrste_prijava;
public interface Vrste_prijavaRepository extends JpaRepository<Vrste_prijava, Integer>{
	@Query(
			  value = "SELECT *  FROM vrste_prijave u ORDER BY u.naziv_vrste", 
			  nativeQuery = true)
	Collection<Vrste_prijava> findAllEntity();
	
}
