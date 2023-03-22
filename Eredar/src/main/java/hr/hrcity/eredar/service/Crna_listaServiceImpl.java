package hr.hrcity.eredar.service;


import java.util.Optional;


import javax.persistence.EntityManagerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hr.hrcity.eredar.exception.ResourceNotFoundException;
import hr.hrcity.eredar.model.Crna_lista;
import hr.hrcity.eredar.repository.Crna_listaRepository;


@Service
@Transactional
public class Crna_listaServiceImpl implements Crna_listaService {

	@Autowired
	private Crna_listaRepository dataRepository;

	EntityManagerFactory emf;

	@Override
	public Crna_lista createEntity(Crna_lista data) {
		return dataRepository.save(data);
	}

	@Override
	public Crna_lista updateEntity(Crna_lista data) throws ResourceNotFoundException {
		Optional<Crna_lista> productDb = this.dataRepository.findById(data.getId_crna());

		if (productDb.isPresent()) {
			Crna_lista dataUpdate = productDb.get();
			dataUpdate.setRazlog(data.getRazlog());
			dataUpdate.setDatum(data.getDatum());
			dataRepository.save(dataUpdate);
			return dataUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found.");
		}
	}

	@Override
	public Iterable<Crna_lista> getAllEntity() {
		return this.dataRepository.findAllEntity();
	}

	@Override
	public Crna_lista getEntityById(Integer entityId) {

		if (entityId == 0)
			return new Crna_lista();

		Optional<Crna_lista> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			return productDb.get();
		} else {
			return new Crna_lista();
		}
	}

	@Override
	public void deleteEntity(Integer entityId) {
		Optional<Crna_lista> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			this.dataRepository.delete(productDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + entityId);
		}

	}

	
}

