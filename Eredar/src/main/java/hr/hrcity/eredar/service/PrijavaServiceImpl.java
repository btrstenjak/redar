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
import hr.hrcity.eredar.model.Prijava;
import hr.hrcity.eredar.repository.PrijavaRepository;


@Service
@Transactional
public class PrijavaServiceImpl implements PrijavaService {

	@Autowired
	private PrijavaRepository dataRepository;

	@Autowired
	EntityManagerFactory emf;

	@Override
	public Prijava createEntity(Prijava data) {
		return dataRepository.save(data);
	}

	@Override
	public Prijava updateEntity(Prijava data) throws ResourceNotFoundException {
		Optional<Prijava> productDb = this.dataRepository.findById(data.getId_prijava());

		if (productDb.isPresent()) {
			Prijava dataUpdate = productDb.get();
			dataUpdate.setNaslov(data.getNaslov());
			dataUpdate.setNapomena(data.getNapomena());
			dataRepository.save(dataUpdate);
			return dataUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found.");
		}
	}

	@Override
	public Iterable<Prijava> getAllEntity() {
		return this.dataRepository.findAllEntity();
	}

	@Override
	public Prijava getEntityById(long entityId) {

		if (entityId == 0)
			return new Prijava();

		Optional<Prijava> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			return productDb.get();
		} else {
			return new Prijava();
		}
	}

	@Override
	public void deleteEntity(long entityId) {
		Optional<Prijava> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			this.dataRepository.delete(productDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + entityId);
		}

	}
}

