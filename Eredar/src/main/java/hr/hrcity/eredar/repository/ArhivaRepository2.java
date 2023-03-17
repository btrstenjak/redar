package hr.hrcity.eredar.repository;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hr.hrcity.eredar.model.Arhiva;


public interface ArhivaRepository extends JpaRepository<Arhiva,Date> {

	@Query(
			value =  "SELECT *  FROM arhiva u ORDER BY u.naziv",
			nativeQuery = true)
	
	Collection<Arhiva> findAllEntity();
}
