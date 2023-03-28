package hr.hrcity.eredar.service;


import java.util.Optional;


import javax.persistence.EntityManagerFactory;

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
}


