package hr.hrcity.eredar.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hr.hrcity.eredar.model.Status_naloga;
public interface Status_nalogaRepository extends JpaRepository<Status_naloga, Long>{

	@Query(
			  value = "SELECT *  FROM Status_naloga u ORDER BY u.naziv_status", 
			  nativeQuery = true)
	Collection<Status_naloga> findAllEntity();
	
}
