package hr.hrcity.eredar.service;

import java.util.Optional;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hr.hrcity.eredar.exception.ResourceNotFoundException;
import hr.hrcity.eredar.model.Opcina_lokacija;
import hr.hrcity.eredar.repository.Opcina_lokacijaRepository;


@Service
@Transactional
public class Opcina_lokacijaServiceImpl implements Opcina_lokacijaService {

	@Autowired
	private Opcina_lokacijaRepository dataRepository;

	@Autowired
	EntityManagerFactory emf;

	@Override
	public Opcina_lokacija createEntity(Opcina_lokacija data) {
		return dataRepository.save(data);
	}

	@Override
	public Opcina_lokacija updateEntity(Opcina_lokacija data) throws ResourceNotFoundException {
		Optional<Opcina_lokacija> productDb = this.dataRepository.findById(data.getId_opcina());

		if (productDb.isPresent()) {
			Opcina_lokacija dataUpdate = productDb.get();
			dataUpdate.setNaziv(data.getNaziv());
			dataUpdate.setEmail(data.getEmail());
			dataRepository.save(dataUpdate);
			return dataUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found.");
		}
	}

	@Override
	public Iterable<Opcina_lokacija> getAllEntity() {
		return this.dataRepository.findAllEntity();
	}

	@Override
	public Opcina_lokacija getEntityById(long entityId) {

		if (entityId == 0)
			return new Opcina_lokacija();

		Optional<Opcina_lokacija> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			return productDb.get();
		} else {
			return new Opcina_lokacija();
		}
	}

	@Override
	public void deleteEntity(long entityId) {
		Optional<Opcina_lokacija> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			this.dataRepository.delete(productDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + entityId);
		}

	}

}

