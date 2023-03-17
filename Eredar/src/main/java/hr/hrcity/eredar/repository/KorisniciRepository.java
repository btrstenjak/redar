package hr.hrcity.eredar.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hr.hrcity.eredar.model.Korisnici;

public interface KorisniciRepository extends JpaRepository<Korisnici, Long>{
	@Query(
			  value = "SELECT *  FROM korisnici u ORDER BY u.ime_prezime", 
			  nativeQuery = true)
	Collection<Korisnici> findAllEntity();

}
