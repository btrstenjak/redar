package hr.hrcity.eredar.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import hr.hrcity.eredar.model.Vrste_dokumenata;


public interface Vrste_dokumenataRepository extends JpaRepository<Vrste_dokumenata, Long> {

	@Query(
			  value = "SELECT *  FROM vrste_dokumenata u ORDER BY u.naziv", 
			  nativeQuery = true)
	Collection<Vrste_dokumenata> findAllEntity();
}

	