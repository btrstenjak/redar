package hr.hrcity.eredar.service;

import java.util.Optional;


import javax.persistence.EntityManagerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hr.hrcity.eredar.exception.ResourceNotFoundException;
import hr.hrcity.eredar.model.Info_komunalni;
import hr.hrcity.eredar.repository.Info_komunalniRepository;


@Service
@Transactional
public class Info_komunalniServiceImpl implements Info_komunalniService {

	@Autowired
	private Info_komunalniRepository dataRepository;

	@Autowired
	EntityManagerFactory emf;

	@Override
	public Info_komunalni createEntity(Info_komunalni data) {
		return dataRepository.save(data);
	}

	@Override
	public Info_komunalni updateEntity(Info_komunalni data) throws ResourceNotFoundException {
		Optional<Info_komunalni> productDb = this.dataRepository.findById(data.getId_info());

		if (productDb.isPresent()) {
			Info_komunalni dataUpdate = productDb.get();
			dataUpdate.setNaslov(data.getNaslov());
			dataUpdate.setPoruka(data.getPoruka());
			dataRepository.save(dataUpdate);
			return dataUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found.");
		}
	}

	@Override
	public Iterable<Info_komunalni> getAllEntity() {
		return this.dataRepository.findAllEntity();
	}

	@Override
	public Info_komunalni getEntityById(long entityId) {

		if (entityId == 0)
			return new Info_komunalni();

		Optional<Info_komunalni> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			return productDb.get();
		} else {
			return new Info_komunalni();
		}
	}

	@Override
	public void deleteEntity(long entityId) {
		Optional<Info_komunalni> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			this.dataRepository.delete(productDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + entityId);
		}

	}
}