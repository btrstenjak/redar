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
import hr.hrcity.eredar.model.Oglas;
import hr.hrcity.eredar.repository.OglasRepository;


@Service
@Transactional
public class OglasServiceImpl implements OglasService {

	@Autowired
	private OglasRepository dataRepository;

	@Autowired
	EntityManagerFactory emf;

	@Override
	public Oglas createEntity(Oglas data) {
		return dataRepository.save(data);
	}

	@Override
	public Oglas updateEntity(Oglas data) throws ResourceNotFoundException {
		Optional<Oglas> productDb = this.dataRepository.findById(data.getId_oglas());

		if (productDb.isPresent()) {
			Oglas dataUpdate = productDb.get();
			dataUpdate.setTekst_1(data.getTekst_1());
			dataUpdate.setTekst_2(data.getTekst_2());
			dataRepository.save(dataUpdate);
			return dataUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found.");
		}
	}

	@Override
	public Iterable<Oglas> getAllEntity() {
		return this.dataRepository.findAllEntity();
	}

	@Override
	public Oglas getEntityById(long entityId) {

		if (entityId == 0)
			return new Oglas();

		Optional<Oglas> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			return productDb.get();
		} else {
			return new Oglas();
		}
	}

	@Override
	public void deleteEntity(long entityId) {
		Optional<Oglas> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			this.dataRepository.delete(productDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + entityId);
		}

	}


}

