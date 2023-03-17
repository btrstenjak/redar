package hr.hrcity.eredar.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hr.hrcity.eredar.model.Info_komunalni;
public interface Info_komunalniRepository extends JpaRepository<Info_komunalni, Long>{
	@Query(
			  value = "SELECT *  FROM info_komunalni u ORDER BY u.naslov", 
			  nativeQuery = true)
	Collection<Info_komunalni> findAllEntity();

}
