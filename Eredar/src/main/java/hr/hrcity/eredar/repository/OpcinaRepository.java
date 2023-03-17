package hr.hrcity.eredar.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hr.hrcity.eredar.model.Opcina;

public interface OpcinaRepository extends JpaRepository<Opcina, Long>{
	@Query(
			  value = "SELECT *  FROM opcia u ORDER BY u.naziv_opcine", 
			  nativeQuery = true)
	Collection<Opcina> findAllEntity();

}
