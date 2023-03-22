package hr.hrcity.eredar.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import hr.hrcity.eredar.model.Upravitelji;

public interface UpraviteljiRepository extends JpaRepository<Upravitelji, Integer>{
	@Query(
			  value = "SELECT *  FROM upravitelj u ORDER BY u.ime_prezime", 
			  nativeQuery = true)
	Collection<Upravitelji> findAllEntity();
}
