package hr.hrcity.eredar.service;

import java.util.Optional;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hr.hrcity.eredar.exception.ResourceNotFoundException;
import hr.hrcity.eredar.model.Error_log;
import hr.hrcity.eredar.repository.Error_logRepository;


@Service
@Transactional
public class Error_logServiceImpl implements Error_logService {

	@Autowired
	private Error_logRepository dataRepository;

	@Autowired
	EntityManagerFactory emf;

	@Override
	public Error_log createEntity(Error_log data) {
		return dataRepository.save(data);
	}

	@Override
	public Error_log updateEntity(Error_log data) throws ResourceNotFoundException {
		Optional<Error_log> productDb = this.dataRepository.findById(data.getId_error());

		if (productDb.isPresent()) {
			Error_log dataUpdate = productDb.get();
			dataUpdate.setOpis(data.getOpis());
			dataRepository.save(dataUpdate);
			return dataUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found.");
		}
	}

	@Override
	public Iterable<Error_log> getAllEntity() {
		return this.dataRepository.findAllEntity();
	}

	@Override
	public Error_log getEntityById(long entityId) {

		if (entityId == 0)
			return new Error_log();

		Optional<Error_log> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			return productDb.get();
		} else {
			return new Error_log();
		}
	}

	@Override
	public void deleteEntity(long entityId) {
		Optional<Error_log> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			this.dataRepository.delete(productDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + entityId);
		}

	}
}
