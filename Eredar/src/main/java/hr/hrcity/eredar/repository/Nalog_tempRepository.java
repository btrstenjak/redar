package hr.hrcity.eredar.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import hr.hrcity.eredar.model.Nalog_temp;

public interface Nalog_tempRepository extends JpaRepository<Nalog_temp, Long>{
	@Query(
			  value = "SELECT *  FROM nalog_temp u ORDER BY u.naslov", 
			  nativeQuery = true)
	Collection<Nalog_temp> findAllEntity();

}
