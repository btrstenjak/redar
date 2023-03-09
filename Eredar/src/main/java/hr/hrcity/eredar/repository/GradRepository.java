package hr.hrcity.eredar.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hr.hrcity.eredar.model.Grad;

public interface GradRepository extends JpaRepository<Grad, Long>{
	@Query(
			  value = "SELECT *  FROM grad u ORDER BY u.naziv", 
			  nativeQuery = true)
	Collection<Grad> findAllEntity();
	
}
