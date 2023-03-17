package hr.hrcity.eredar.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import hr.hrcity.eredar.model.Nalog;

public interface NalogRepository extends JpaRepository<Nalog, Long>{
	@Query(
			  value = "SELECT *  FROM nalog u ORDER BY u.naslov", 
			  nativeQuery = true)
	Collection<Nalog> findAllEntity();

}
