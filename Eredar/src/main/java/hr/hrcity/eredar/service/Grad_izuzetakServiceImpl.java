package hr.hrcity.eredar.service;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hr.hrcity.eredar.exception.ResourceNotFoundException;
import hr.hrcity.eredar.model.Grad_izuzetak;
import hr.hrcity.eredar.repository.Grad_izuzetakRepository;

@Service
@Transactional
public class Grad_izuzetakServiceImpl implements Grad_izuzetakService {

	@Autowired
	private Grad_izuzetakRepository dataRepository;

	@Autowired
	EntityManagerFactory emf;

	@Override
	public Grad_izuzetak createEntity(Grad_izuzetak data) {
		return dataRepository.save(data);
	}

	@Override
	public Grad_izuzetak updateEntity(Grad_izuzetak data) throws ResourceNotFoundException {
		Optional<Grad_izuzetak> productDb = this.dataRepository.findById(data.getId_grad_izuzetak());

		if (productDb.isPresent()) {
			Grad_izuzetak dataUpdate = productDb.get();
			dataUpdate.setId_grad(data.getId_grad());
			dataRepository.save(dataUpdate);
			return dataUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found.");
		}
	}

	@Override
	public Iterable<Grad_izuzetak> getAllEntity() {
		return this.dataRepository.findAllEntity();
	}

	@Override
	public Grad_izuzetak getEntityById(long entityId) {

		if (entityId == 0)
			return new Grad_izuzetak();

		Optional<Grad_izuzetak> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			return productDb.get();
		} else {
			return new Grad_izuzetak();
		}
	}

	@Override
	public void deleteEntity(long entityId) {
		Optional<Grad_izuzetak> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			this.dataRepository.delete(productDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + entityId);
		}

	}
}

