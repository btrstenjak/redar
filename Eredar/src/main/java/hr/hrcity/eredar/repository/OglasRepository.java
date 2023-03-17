package hr.hrcity.eredar.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hr.hrcity.eredar.model.Oglas;
public interface OglasRepository extends JpaRepository<Oglas, Long>{
	@Query(
			  value = "SELECT *  FROM oglas u ORDER BY u.tekst_1", 
			  nativeQuery = true)
	Collection<Oglas> findAllEntity();

}
