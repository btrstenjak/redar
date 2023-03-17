package hr.hrcity.eredar.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hr.hrcity.eredar.model.Prijava;

public interface PrijavaRepository extends JpaRepository<Prijava, Long>{
	@Query(
			  value = "SELECT *  FROM prijava u ORDER BY u.vrsta_naziv", 
			  nativeQuery = true)
	Collection<Prijava> findAllEntity();

}
