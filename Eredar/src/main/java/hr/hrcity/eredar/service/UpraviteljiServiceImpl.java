package hr.hrcity.eredar.service;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import hr.hrcity.eredar.exception.ResourceNotFoundException;
import hr.hrcity.eredar.model.Upravitelji;
import hr.hrcity.eredar.repository.UpraviteljiRepository;


@Service
@Transactional
public class UpraviteljiServiceImpl implements UpraviteljiService {

	@Autowired
	private UpraviteljiRepository dataRepository;

	@Autowired
	EntityManagerFactory emf;

	@Override
	public Upravitelji createEntity(Upravitelji data) {
		return dataRepository.save(data);
	}

	@Override
	public Upravitelji updateEntity(Upravitelji data) throws ResourceNotFoundException {
		Optional<Upravitelji> productDb = this.dataRepository.findById(data.getId_upravitelj());

		if (productDb.isPresent()) {
			Upravitelji dataUpdate = productDb.get();
			dataUpdate.setIme_prezime(data.getIme_prezime());
			dataUpdate.setNazivGrada(data.getNazivGrada());
			dataUpdate.setEmail(data.getEmail());
			dataRepository.save(dataUpdate);
			return dataUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found.");
		}
	}

	@Override
	public Iterable<Upravitelji> getAllEntity() {
		return this.dataRepository.findAllEntity();
	}

	@Override
	public Upravitelji getEntityById(Integer entityId) {

		if (entityId == 0)
			return new Upravitelji();

		Optional<Upravitelji> productDb  = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			return productDb.get();
		} else {
			return new Upravitelji();
		}
	}

	@Override
	public void deleteEntity(Integer entityId) {
		Optional<Upravitelji> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			this.dataRepository.delete(productDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + entityId);
		}

	}
}

