package hr.hrcity.eredar.service;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import hr.hrcity.eredar.exception.ResourceNotFoundException;
import hr.hrcity.eredar.model.Nalog;
import hr.hrcity.eredar.repository.NalogRepository;


@Service
@Transactional
public class NalogServiceImpl implements NalogService {

	@Autowired
	private NalogRepository dataRepository;

	@Autowired
	EntityManagerFactory emf;

	@Override
	public Nalog createEntity(Nalog data) {
		return dataRepository.save(data);
	}

	@Override
	public Nalog updateEntity(Nalog data) throws ResourceNotFoundException {
		Optional<Nalog> productDb = this.dataRepository.findById(data.getId_nalog());

		if (productDb.isPresent()) {
			Nalog dataUpdate = productDb.get();
			dataUpdate.setNaslov(data.getNaslov());
			dataUpdate.setTekst_naslova(data.getTekst_naslova());
			dataRepository.save(dataUpdate);
			return dataUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found.");
		}
	}

	@Override
	public Iterable<Nalog> getAllEntity() {
		return this.dataRepository.findAllEntity();
	}

	@Override
	public Nalog getEntityById(long entityId) {

		if (entityId == 0)
			return new Nalog();

		Optional<Nalog> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			return productDb.get();
		} else {
			return new Nalog();
		}
	}

	@Override
	public void deleteEntity(long entityId) {
		Optional<Nalog> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			this.dataRepository.delete(productDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + entityId);
		}

	}
}

