package hr.hrcity.eredar.repository;


import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hr.hrcity.eredar.model.Error_log;



public interface Error_logRepository extends JpaRepository<Error_log, Long> {

	
	@Query(
			  value = "SELECT *  FROM error_log u ORDER BY u.id_error", 
			  nativeQuery = true)
	Collection<Error_log> findAllEntity();
	
}
