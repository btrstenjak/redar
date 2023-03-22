package hr.hrcity.eredar.service;


import java.util.Optional;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import hr.hrcity.eredar.exception.ResourceNotFoundException;
import hr.hrcity.eredar.model.Radni_dokumenti;
import hr.hrcity.eredar.repository.Radni_dokumentiRepository;


@Service
@Transactional
public class Radni_dokumentiServiceImpl implements Radni_dokumentiService {

	@Autowired
	private Radni_dokumentiRepository dataRepository;

	@Autowired
	EntityManagerFactory emf;

	@Override
	public Radni_dokumenti createEntity(Radni_dokumenti data) {
		return dataRepository.save(data);
	}

	@Override
	public Radni_dokumenti updateEntity(Radni_dokumenti data) throws ResourceNotFoundException {
		Optional<Radni_dokumenti> productDb = this.dataRepository.findById(data.getId_radni_dokument());

		if (productDb.isPresent()) {
			Radni_dokumenti dataUpdate = productDb.get();
			dataUpdate.setNaslov_dokumenta(data.getNaslov_dokumenta());
			dataUpdate.setObrazlozenje(data.getObrazlozenje());
			dataUpdate.setPravoljek(data.getPravoljek());
			dataRepository.save(dataUpdate);
			return dataUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found.");
		}
	}

	@Override
	public Iterable<Radni_dokumenti> getAllEntity() {
		return this.dataRepository.findAllEntity();
	}

	@Override
	public Radni_dokumenti getEntityById(long entityId) {

		if (entityId == 0)
			return new Radni_dokumenti();

		Optional<Radni_dokumenti> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			return productDb.get();
		} else {
			return new Radni_dokumenti();
		}
	}

	@Override
	public void deleteEntity(long entityId) {
		Optional<Radni_dokumenti> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			this.dataRepository.delete(productDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + entityId);
		}

	}

}

