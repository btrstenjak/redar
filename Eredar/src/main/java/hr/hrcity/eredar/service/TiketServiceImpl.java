package hr.hrcity.eredar.service;


import java.util.Optional;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import hr.hrcity.eredar.exception.ResourceNotFoundException;
import hr.hrcity.eredar.model.Tiket;
import hr.hrcity.eredar.repository.TiketRepository;


@Service
@Transactional
public class TiketServiceImpl implements TiketService {

	@Autowired
	private TiketRepository dataRepository;

	@Autowired
	EntityManagerFactory emf;

	@Override
	public Tiket createEntity(Tiket data) {
		return dataRepository.save(data);
	}

	@Override
	public Tiket updateEntity(Tiket data) throws ResourceNotFoundException {
		Optional<Tiket> productDb = this.dataRepository.findById(data.getId_tiket());

		if (productDb.isPresent()) {
			Tiket dataUpdate = productDb.get();
			dataUpdate.setAktivacija(data.getAktivacija());
			dataUpdate.setPitanje(data.getPitanje());
			dataUpdate.setOdgovor(data.getOdgovor());
			dataRepository.save(dataUpdate);
			return dataUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found.");
		}
	}

	@Override
	public Iterable<Tiket> getAllEntity() {
		return this.dataRepository.findAllEntity();
	}

	@Override
	public Tiket getEntityById(long entityId) {

		if (entityId == 0)
			return new Tiket();

		Optional<Tiket> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			return productDb.get();
		} else {
			return new Tiket();
		}
	}

	@Override
	public void deleteEntity(long entityId) {
		Optional<Tiket> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			this.dataRepository.delete(productDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + entityId);
		}

	}

}


