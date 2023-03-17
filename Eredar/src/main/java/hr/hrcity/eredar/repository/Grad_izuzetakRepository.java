package hr.hrcity.eredar.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import hr.hrcity.eredar.model.Grad_izuzetak;

public interface Grad_izuzetakRepository extends JpaRepository<Grad_izuzetak, Long>{
	@Query(
			  value = "SELECT *  FROM grad_izuzetak u ORDER BY u.id_grad_izuzetak", 
			  nativeQuery = true)
	Collection<Grad_izuzetak> findAllEntity();

}