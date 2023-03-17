package hr.hrcity.eredar.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hr.hrcity.eredar.model.Tiket;
public interface TiketRepository extends JpaRepository<Tiket, Long>{
	@Query(
			  value = "SELECT *  FROM tiket u ORDER BY u.vrsta", 
			  nativeQuery = true)
	Collection<Tiket> findAllEntity();
	
}
