package hr.hrcity.eredar.service;


import java.util.Optional;


import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hr.hrcity.eredar.exception.ResourceNotFoundException;
import hr.hrcity.eredar.model.Radni_dokumenti_temp;
import hr.hrcity.eredar.repository.Radni_dokumenti_tempRepository;


@Service
@Transactional
public class Radni_dokumenti_tempServiceImpl implements Radni_dokumenti_tempService {

	@Autowired
	private Radni_dokumenti_tempRepository dataRepository;

	@Autowired
	EntityManagerFactory emf;

	@Override 
	public Radni_dokumenti_temp createEntity(Radni_dokumenti_temp data) {
		return dataRepository.save(data);
	}

	@Override
	public Radni_dokumenti_temp updateEntity(Radni_dokumenti_temp data) throws ResourceNotFoundException {
		Optional<Radni_dokumenti_temp> productDb = this.dataRepository.findById(data.getId_predlozak());

		if (productDb.isPresent()) {
			Radni_dokumenti_temp dataUpdate = productDb.get();
			dataUpdate.setNaziv_predloska(data.getNaziv_predloska());
			dataUpdate.setObrazlozenje(data.getObrazlozenje());
			dataRepository.save(dataUpdate);
			return dataUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found.");
		}
	}

	@Override
	public Iterable<Radni_dokumenti_temp> getAllEntity() {
		return this.dataRepository.findAllEntity();
	}

	@Override
	public Radni_dokumenti_temp getEntityById(long entityId) {

		if (entityId == 0)
			return new Radni_dokumenti_temp();

		Optional<Radni_dokumenti_temp> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			return productDb.get();
		} else {
			return new Radni_dokumenti_temp();
		}
	}

	@Override
	public void deleteEntity(long entityId) {
		Optional<Radni_dokumenti_temp> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			this.dataRepository.delete(productDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + entityId);
		}

	}

}

