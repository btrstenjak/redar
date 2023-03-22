package hr.hrcity.eredar.service;


import java.util.Optional;

import javax.persistence.EntityManagerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hr.hrcity.eredar.exception.ResourceNotFoundException;
import hr.hrcity.eredar.model.Grad_lokacija;
import hr.hrcity.eredar.repository.Grad_lokacijaRepository;


@Service
@Transactional
public class Grad_lokacijaServiceImpl implements Grad_lokacijaService {

	@Autowired
	private Grad_lokacijaRepository dataRepository;

	@Autowired
	EntityManagerFactory emf;

	@Override
	public Grad_lokacija createEntity(Grad_lokacija data) {
		return dataRepository.save(data);
	}

	@Override
	public Grad_lokacija updateEntity(Grad_lokacija data) throws ResourceNotFoundException {
		Optional<Grad_lokacija> productDb = this.dataRepository.findById(data.getId_grad());

		if (productDb.isPresent()) {
			Grad_lokacija dataUpdate = productDb.get();
			dataUpdate.setNaziv(data.getNaziv());
			dataUpdate.setEmail(data.getEmail());
			dataRepository.save(dataUpdate);
			return dataUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found.");
		}
	}

	@Override
	public Iterable<Grad_lokacija> getAllEntity() {
		return this.dataRepository.findAllEntity();
	}

	@Override
	public Grad_lokacija getEntityById(long entityId) {

		if (entityId == 0)
			return new Grad_lokacija();

		Optional<Grad_lokacija> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			return productDb.get();
		} else {
			return new Grad_lokacija();
		}
	}

	@Override
	public void deleteEntity(long entityId) {
		Optional<Grad_lokacija> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			this.dataRepository.delete(productDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + entityId);
		}

	}
	
}
