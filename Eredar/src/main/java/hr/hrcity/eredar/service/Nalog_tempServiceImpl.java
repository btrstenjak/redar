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
import hr.hrcity.eredar.model.Nalog_temp;
import hr.hrcity.eredar.repository.Nalog_tempRepository;


@Service
@Transactional
public class Nalog_tempServiceImpl implements Nalog_tempService {

	@Autowired
	private Nalog_tempRepository dataRepository;

	@Autowired
	EntityManagerFactory emf;

	@Override
	public Nalog_temp createEntity(Nalog_temp data) {
		return dataRepository.save(data);
	}

	@Override
	public Nalog_temp updateEntity(Nalog_temp data) throws ResourceNotFoundException {
		Optional<Nalog_temp> productDb = this.dataRepository.findById(data.getId_predlozak());

		if (productDb.isPresent()) {
			Nalog_temp dataUpdate = productDb.get();
			dataUpdate.setNaslov(data.getNaslov());
			dataUpdate.setOznaka_broj(data.getOznaka_broj());
			dataUpdate.setTekst_naslova(data.getTekst_naslova());
			dataRepository.save(dataUpdate);
			return dataUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found.");
		}
	}

	@Override
	public Iterable<Nalog_temp> getAllEntity() {
		return this.dataRepository.findAllEntity();
	}

	@Override
	public Nalog_temp getEntityById(long entityId) {

		if (entityId == 0)
			return new Nalog_temp();

		Optional<Nalog_temp> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			return productDb.get();
		} else {
			return new Nalog_temp();
		}
	}

	@Override
	public void deleteEntity(long entityId) {
		Optional<Nalog_temp> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			this.dataRepository.delete(productDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + entityId);
		}

	}
}