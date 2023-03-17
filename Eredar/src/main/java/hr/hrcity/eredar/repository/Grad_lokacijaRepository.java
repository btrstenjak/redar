package hr.hrcity.eredar.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hr.hrcity.eredar.model.Grad_lokacija;

public interface Grad_lokacijaRepository extends JpaRepository<Grad_lokacija, Long>{
	@Query(
			  value = "SELECT *  FROM grad_lokacija u ORDER BY u.naziv", 
			  nativeQuery = true)
	Collection<Grad_lokacija> findAllEntity();
	

}
