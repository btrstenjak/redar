package hr.hrcity.eredar.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hr.hrcity.eredar.model.Opcina_lokacija;

public interface Opcina_lokacijaRepository extends JpaRepository<Opcina_lokacija, Long>{
	@Query(
			  value = "SELECT *  FROM opcina_lokacija u ORDER BY u.naziv", 
			  nativeQuery = true)
	Collection<Opcina_lokacija> findAllEntity();
	
}

