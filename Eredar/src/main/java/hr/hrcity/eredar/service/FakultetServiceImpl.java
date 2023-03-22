package hr.hrcity.eredar.service;

import java.util.Optional;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hr.hrcity.eredar.exception.ResourceNotFoundException;
import hr.hrcity.eredar.model.Fakultet;
import hr.hrcity.eredar.repository.FakultetRepository;


@Service
@Transactional
public class FakultetServiceImpl implements FakultetService {

	@Autowired
	private FakultetRepository dataRepository;

	@Autowired
	EntityManagerFactory emf;

	@Override
	public Fakultet createEntity(Fakultet data) {
		return dataRepository.save(data);
	}

	@Override
	public Fakultet updateEntity(Fakultet data) throws ResourceNotFoundException {
		Optional<Fakultet> productDb = this.dataRepository.findById(data.getId());

		if (productDb.isPresent()) {
			Fakultet dataUpdate = productDb.get();
			dataUpdate.setNaziv(data.getNaziv());
			dataUpdate.setStudij(data.getStudij());
			dataRepository.save(dataUpdate);
			return dataUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found.");
		}
	}

	@Override
	public Iterable<Fakultet> getAllEntity() {
		return this.dataRepository.findAllEntity();
	}

	@Override
	public Fakultet getEntityById(Integer entityId) {

		if (entityId == 0)
			return new Fakultet();

		Optional<Fakultet> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			return productDb.get();
		} else {
			return new Fakultet();
		}
	}

	@Override
	public void deleteEntity(Integer entityId) {
		Optional<Fakultet> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			this.dataRepository.delete(productDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + entityId);
		}

	}
}