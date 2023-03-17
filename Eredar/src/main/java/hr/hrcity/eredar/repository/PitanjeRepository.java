package hr.hrcity.eredar.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hr.hrcity.eredar.model.Pitanje;

public interface PitanjeRepository extends JpaRepository<Pitanje, Long>{
	@Query(
			  value = "SELECT *  FROM pitanje u ORDER BY u.naslov", 
			  nativeQuery = true)
	Collection<Pitanje> findAllEntity();

}
