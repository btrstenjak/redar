package hr.hrcity.eredar.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import hr.hrcity.eredar.model.Fakultet;

public interface FakultetRepository extends JpaRepository<Fakultet, Integer> {

	
	@Query(
			  value = "SELECT *  FROM Fakultet u ORDER BY u.naziv", 
			  nativeQuery = true)
	Collection<Fakultet> findAllEntity();
}
