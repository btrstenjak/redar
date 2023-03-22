package hr.hrcity.eredar.service;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import hr.hrcity.eredar.exception.ResourceNotFoundException;
import hr.hrcity.eredar.model.Skin;
import hr.hrcity.eredar.repository.SkinRepository;


@Service
@Transactional
public class SkinServiceImpl implements SkinService {

	@Autowired
	private SkinRepository dataRepository;

	@Autowired
	EntityManagerFactory emf;

	@Override
	public Skin createEntity(Skin data) {
		return dataRepository.save(data);
	}

	@Override
	public Skin updateEntity(Skin data) throws ResourceNotFoundException {
		Optional<Skin> productDb = this.dataRepository.findById(data.getId_skin());

		if (productDb.isPresent()) {
			Skin dataUpdate = productDb.get();
			dataUpdate.setPath(data.getPath());
			dataUpdate.setAdresa(data.getAdresa());
			dataRepository.save(dataUpdate);
			return dataUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found.");
		}
	}

	@Override
	public Iterable<Skin> getAllEntity() {
		return this.dataRepository.findAllEntity();
	}

	@Override
	public Skin getEntityById(long entityId) {

		if (entityId == 0)
			return new Skin();

		Optional<Skin> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			return productDb.get();
		} else {
			return new Skin();
		}
	}

	@Override
	public void deleteEntity(long entityId) {
		Optional<Skin> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			this.dataRepository.delete(productDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + entityId);
		}

	}

}

