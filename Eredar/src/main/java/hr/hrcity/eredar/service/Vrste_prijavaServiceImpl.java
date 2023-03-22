package hr.hrcity.eredar.service;

import java.util.Optional;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import hr.hrcity.eredar.exception.ResourceNotFoundException;
import hr.hrcity.eredar.model.Vrste_prijava;
import hr.hrcity.eredar.repository.Vrste_prijavaRepository;


@Service
@Transactional
public class Vrste_prijavaServiceImpl implements Vrste_prijavaService {

	@Autowired
	private Vrste_prijavaRepository dataRepository;

	@Autowired
	EntityManagerFactory emf;

	@Override
	public Vrste_prijava createEntity(Vrste_prijava data) {
		return dataRepository.save(data);
	}

	@Override
	public Vrste_prijava updateEntity(Vrste_prijava data) throws ResourceNotFoundException {
		Optional<Vrste_prijava> productDb = this.dataRepository.findById(data.getId_vrsta());

		if (productDb.isPresent()) {
			Vrste_prijava dataUpdate = productDb.get();
			dataUpdate.setNaziv_vrste(data.getNaziv_vrste());
			dataRepository.save(dataUpdate);
			return dataUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found.");
		}
	}

	@Override
	public Iterable<Vrste_prijava> getAllEntity() {
		return this.dataRepository.findAllEntity();
	}

	@Override
	public Vrste_prijava getEntityById(int entityId) {

		if (entityId == 0)
			return new Vrste_prijava();

		Optional<Vrste_prijava> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			return productDb.get();
		} else {
			return new Vrste_prijava();
		}
	}

	@Override
	public void deleteEntity(int entityId) {
		Optional<Vrste_prijava> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			this.dataRepository.delete(productDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + entityId);
		}

	}

}

