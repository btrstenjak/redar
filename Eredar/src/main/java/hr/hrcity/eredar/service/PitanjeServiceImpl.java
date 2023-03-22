package hr.hrcity.eredar.service;

import java.util.Optional;
import javax.persistence.EntityManagerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hr.hrcity.eredar.exception.ResourceNotFoundException;
import hr.hrcity.eredar.model.Pitanje;
import hr.hrcity.eredar.repository.PitanjeRepository;


@Service
@Transactional
public class PitanjeServiceImpl implements PitanjeService {

	@Autowired
	private PitanjeRepository dataRepository;

	@Autowired
	EntityManagerFactory emf;

	@Override
	public Pitanje createEntity(Pitanje data) {
		return dataRepository.save(data);
	}

	@Override
	public Pitanje updateEntity(Pitanje data) throws ResourceNotFoundException {
		Optional<Pitanje> productDb = this.dataRepository.findById(data.getId_pitanje());

		if (productDb.isPresent()) {
			Pitanje dataUpdate = productDb.get();
			
			dataUpdate.setNaslov(data.getNaslov());
			dataUpdate.setNapomena(data.getNapomena());
			dataUpdate.setNaziv_grad(data.getNaziv_grad());
			dataUpdate.setAdresa(data.getAdresa());
			dataRepository.save(dataUpdate);
			return dataUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found.");
		}
	}

	@Override
	public Iterable<Pitanje> getAllEntity() {
		return this.dataRepository.findAllEntity();
	}

	@Override
	public Pitanje getEntityById(long entityId) {

		if (entityId == 0)
			return new Pitanje();

		Optional<Pitanje> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			return productDb.get();
		} else {
			return new Pitanje();
		}
	}

	@Override
	public void deleteEntity(long entityId) {
		Optional<Pitanje> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			this.dataRepository.delete(productDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + entityId);
		}

	}
}