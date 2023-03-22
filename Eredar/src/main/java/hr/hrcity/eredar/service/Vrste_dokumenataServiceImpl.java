package hr.hrcity.eredar.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hr.hrcity.eredar.exception.ResourceNotFoundException;
import hr.hrcity.eredar.model.Vrste_dokumenata;
import hr.hrcity.eredar.repository.Vrste_dokumenataRepository;


@Service
@Transactional
public class Vrste_dokumenataServiceImpl implements Vrste_dokumenataService {

	@Autowired
	private Vrste_dokumenataRepository dataRepository;

	@Autowired
	EntityManagerFactory emf;

	@Override
	public Vrste_dokumenata createEntity(Vrste_dokumenata data) {
		return dataRepository.save(data);
	}

	@Override
	public Vrste_dokumenata updateEntity(Vrste_dokumenata data) throws ResourceNotFoundException {
		Optional<Vrste_dokumenata> productDb = this.dataRepository.findById(data.getId_vrsta_dokumenta());

		if (productDb.isPresent()) {
			Vrste_dokumenata dataUpdate = productDb.get();
			dataUpdate.setNaziv_dokumenta(data.getNaziv_dokumenta());			dataRepository.save(dataUpdate);
			return dataUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found.");
		}
	}

	@Override
	public Iterable<Vrste_dokumenata> getAllEntity() {
		return this.dataRepository.findAllEntity();
	}

	@Override
	public Vrste_dokumenata getEntityById(long entityId) {

		if (entityId == 0)
			return new Vrste_dokumenata();

		Optional<Vrste_dokumenata> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			return productDb.get();
		} else {
			return new Vrste_dokumenata();
		}
	}

	@Override
	public void deleteEntity(long entityId) {
		Optional<Vrste_dokumenata> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			this.dataRepository.delete(productDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + entityId);
		}

	}
}

