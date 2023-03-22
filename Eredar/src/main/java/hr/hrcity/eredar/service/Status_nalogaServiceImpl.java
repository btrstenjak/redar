package hr.hrcity.eredar.service;

import java.util.Optional;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hr.hrcity.eredar.exception.ResourceNotFoundException;
import hr.hrcity.eredar.model.Status_naloga;
import hr.hrcity.eredar.repository.Status_nalogaRepository;


@Service
@Transactional
public class Status_nalogaServiceImpl implements Status_nalogaService {

	@Autowired
	private Status_nalogaRepository dataRepository;

	@Autowired
	EntityManagerFactory emf;

	@Override
	public Status_naloga createEntity(Status_naloga data) {
		return dataRepository.save(data);
	}

	@Override
	public Status_naloga updateEntity(Status_naloga data) throws ResourceNotFoundException {
		Optional<Status_naloga> productDb = this.dataRepository.findById(data.getId_status_naloga());

		if (productDb.isPresent()) {
			Status_naloga dataUpdate = productDb.get();
			dataUpdate.setNaziv_status(data.getNaziv_status());
			dataRepository.save(dataUpdate);
			return dataUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found.");
		}
	}

	@Override
	public Iterable<Status_naloga> getAllEntity() {
		return this.dataRepository.findAllEntity();
	}

	@Override
	public Status_naloga getEntityById(long entityId) {

		if (entityId == 0)
			return new Status_naloga();

		Optional<Status_naloga> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			return productDb.get();
		} else {
			return new Status_naloga();
		}
	}

	@Override
	public void deleteEntity(long entityId) {
		Optional<Status_naloga> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			this.dataRepository.delete(productDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + entityId);
		}

	}

}

