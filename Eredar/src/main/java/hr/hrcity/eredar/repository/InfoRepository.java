package hr.hrcity.eredar.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hr.hrcity.eredar.model.Info;
public interface InfoRepository extends JpaRepository<Info, Long>{
	@Query(
			  value = "SELECT *  FROM info u ORDER BY u.naziv", 
			  nativeQuery = true)
	Collection<Info> findAllEntity();

}
