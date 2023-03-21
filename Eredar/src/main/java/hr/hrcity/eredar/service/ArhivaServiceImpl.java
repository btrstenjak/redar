package hr.hrcity.eredar.service;

import java.util.Optional;

import javax.persistence.EntityManagerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hr.hrcity.eredar.exception.ResourceNotFoundException;
import hr.hrcity.eredar.model.Arhiva;
import hr.hrcity.eredar.repository.ArhivaRepository;


@Service
@Transactional
public class ArhivaServiceImpl implements ArhivaService {

	@Autowired
	private ArhivaRepository dataRepository;

	@Autowired
	EntityManagerFactory emf;

	@Override
	public Arhiva createEntity(Arhiva data) {
		return dataRepository.save(data);
	}

	@Override
	public Arhiva updateEntity(Arhiva data) throws ResourceNotFoundException {
		Optional<Arhiva> productDb = this.dataRepository.findById(data.getId_arhiva());

		if (productDb.isPresent()) {
			Arhiva dataUpdate = productDb.get();
			dataUpdate.setNaziv(data.getNaziv());
			dataUpdate.setPutanja(data.getPutanja());
			dataRepository.save(dataUpdate);
			return dataUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found.");
		}
	}

	@Override
	public Iterable<Arhiva> getAllEntity() {
		return this.dataRepository.findAllEntity();
	}

	@Override
	public Arhiva getEntityById(long entityId) {

		if (entityId == 0)
			return new Arhiva();

		Optional<Arhiva> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			return productDb.get();
		} else {
			return new Arhiva();
		}
	}

	@Override
	public void deleteEntity(long entityId) {
		Optional<Arhiva> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			this.dataRepository.delete(productDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + entityId);
		}

	}

}
