package hr.hrcity.eredar.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import hr.hrcity.eredar.model.Radni_dokumenti_temp;

public interface Radni_dokumenti_tempRepository extends JpaRepository<Radni_dokumenti_temp, Long>{
		@Query(
				  value = "SELECT *  FROM radni_dokumenti_temp u ORDER BY u.vrsta", 
				  nativeQuery = true)
		Collection<Radni_dokumenti_temp> findAllEntity();

		Radni_dokumenti_temp save(Radni_dokumenti_temp data);

}
