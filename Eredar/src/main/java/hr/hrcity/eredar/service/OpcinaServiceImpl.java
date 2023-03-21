package hr.hrcity.eredar.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hr.hrcity.eredar.exception.ResourceNotFoundException;
import hr.hrcity.eredar.model.Opcina;
import hr.hrcity.eredar.repository.OpcinaRepository;


@Service
@Transactional
public class OpcinaServiceImpl implements OpcinaService {

	@Autowired
	private OpcinaRepository dataRepository;

	@Autowired
	EntityManagerFactory emf;

	@Override
	public Opcina createEntity(Opcina data) {
		return dataRepository.save(data);
	}

	@Override
	public Opcina updateEntity(Opcina data) throws ResourceNotFoundException {
		Optional<Opcina> productDb = this.dataRepository.findById(data.getId_opcina());

		if (productDb.isPresent()) {
			Opcina dataUpdate = productDb.get();
			dataUpdate.setNaziv_opcine(data.getNaziv_opcine());
			dataUpdate.setZupanija(data.getZupanija());
			dataRepository.save(dataUpdate);
			return dataUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found.");
		}
	}

	@Override
	public Iterable<Opcina> getAllEntity() {
		return this.dataRepository.findAllEntity();
	}

	@Override
	public Opcina getEntityById(long entityId) {

		if (entityId == 0)
			return new Opcina();

		Optional<Opcina> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			return productDb.get();
		} else {
			return new Opcina();
		}
	}

	@Override
	public void deleteEntity(long entityId) {
		Optional<Opcina> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			this.dataRepository.delete(productDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + entityId);
		}

	}

	
	/*
	// API
	@Override
	public ArrayList<Opcina> getAllEntityMob() {
		return (ArrayList<Opcina>) this.dataRepository.findAllEntity();
	}

	@Override
	public ArrayList<Opcina> findListOpcinaUpravitelj() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createNativeQuery("" + "Select o.id_opcina, o.naziv_opcine, o.zupanija, o.id_upravitelj "
				+ " FROM (opcina o INNER JOIN upravitelj u ON o.id_Opcina = u.id_Opcina)  " + " GROUP BY o.id_Opcina "
				+ "   ORDER BY o.naziv ");

		ArrayList<Opcina> listaOL = new ArrayList<Opcina>();

		@SuppressWarnings("unchecked")
		List<Object[]> results = query.getResultList();
		for (Object[] objects : results) {

			Opcina O = new Opcina();
			O.setId_opcina(((BigInteger) objects[0]).longValue()); // id Opcina
			O.setNaziv_opcine((String) objects[1]); // naziv Opcinaa
			O.setZupanija((String) objects[2]); // županija
			O.setId_upravitelj(((BigInteger) objects[3]).longValue()); // id upravitelja
			listaOL.add(O);
		}

		em.getTransaction().commit();
		em.close();



		return listaOL;
	}*/
 
}


