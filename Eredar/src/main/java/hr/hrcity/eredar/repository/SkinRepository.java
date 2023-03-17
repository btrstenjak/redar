package hr.hrcity.eredar.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hr.hrcity.eredar.model.Skin;

public interface SkinRepository extends JpaRepository<Skin, Long>{
	@Query(
			  value = "SELECT *  FROM skin u ORDER BY u.id_skin", 
			  nativeQuery = true)
	Collection<Skin> findAllEntity();
	
}
