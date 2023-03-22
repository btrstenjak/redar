package hr.hrcity.eredar.repository;


import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hr.hrcity.eredar.model.Crna_lista;



public interface Crna_listaRepository extends JpaRepository<Crna_lista, Integer> {

	@Query(
			  value = "SELECT *  FROM crna_lista u ORDER BY u.naziv", 
			  nativeQuery = true)
	
	Collection<Crna_lista> findAllEntity();
}
