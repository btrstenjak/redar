package hr.hrcity.eredar.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hr.hrcity.eredar.model.Radni_dokumenti;

public interface Radni_dokumentiRepository extends JpaRepository<Radni_dokumenti, Long>{
		@Query(
				  value = "SELECT *  FROM radni_dokumenti u ORDER BY u.vrsta", 
				  nativeQuery = true)
		Collection<Radni_dokumenti> findAllEntity();

}
