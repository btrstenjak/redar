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
import hr.hrcity.eredar.model.Grad;
import hr.hrcity.eredar.repository.GradRepository;


@Service
@Transactional
public class GradServiceImpl implements GradService {

	@Autowired
	private GradRepository dataRepository;

	@Autowired
	EntityManagerFactory emf;

	@Override
	public Grad createEntity(Grad data) {
		return dataRepository.save(data);
	}

	@Override
	public Grad updateEntity(Grad data) throws ResourceNotFoundException {
		Optional<Grad> productDb = this.dataRepository.findById(data.getId_grad());

		if (productDb.isPresent()) {
			Grad dataUpdate = productDb.get();
			dataUpdate.setNaziv(data.getNaziv());
			dataUpdate.setZupanija(data.getZupanija());
			dataRepository.save(dataUpdate);
			return dataUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found.");
		}
	}

	@Override
	public Iterable<Grad> getAllEntity() {
		return this.dataRepository.findAllEntity();
	}

	@Override
	public Grad getEntityById(long entityId) {

		if (entityId == 0)
			return new Grad();

		Optional<Grad> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			return productDb.get();
		} else {
			return new Grad();
		}
	}

	@Override
	public void deleteEntity(long entityId) {
		Optional<Grad> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			this.dataRepository.delete(productDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + entityId);
		}

	}

	// API
	@Override
	public ArrayList<Grad> getAllEntityMob() {
		return (ArrayList<Grad>) this.dataRepository.findAllEntity();
	}

	@Override
	public ArrayList<Grad> findListGradUpravitelj() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createNativeQuery("" + "Select g.id_grad, g.	naziv, g.zupanija, g.id_upravitelj "
				+ " FROM (grad g INNER JOIN upravitelj u ON g.id_grad = u.id_grad)  " + " GROUP BY g.id_grad "
				+ "   ORDER BY g.naziv ");

		ArrayList<Grad> listaGL = new ArrayList<Grad>();

		@SuppressWarnings("unchecked")
		List<Object[]> results = query.getResultList();
		for (Object[] objects : results) {

			Grad G = new Grad();
			G.setId_grad(((BigInteger) objects[0]).longValue()); // id grad
			G.setNaziv((String) objects[1]); // naziv grada
			G.setZupanija((String) objects[2]); // županija
			G.setId_upravitelj(((BigInteger) objects[3]).longValue()); // id upravitelja
			listaGL.add(G);
		}

		em.getTransaction().commit();
		em.close();

		return listaGL;
	}

}

