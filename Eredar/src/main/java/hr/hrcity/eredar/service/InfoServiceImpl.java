package hr.hrcity.eredar.service;


import java.util.Optional;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import hr.hrcity.eredar.exception.ResourceNotFoundException;
import hr.hrcity.eredar.model.Info;
import hr.hrcity.eredar.repository.InfoRepository;


@Service
@Transactional
public class InfoServiceImpl implements InfoService {

	@Autowired
	private InfoRepository dataRepository;

	@Autowired
	EntityManagerFactory emf;

	@Override
	public Info createEntity(Info data) {
		return dataRepository.save(data);
	}

	@Override
	public Info updateEntity(Info data) throws ResourceNotFoundException {
		Optional<Info> productDb = this.dataRepository.findById(data.getId_info());

		if (productDb.isPresent()) {
			Info dataUpdate = productDb.get();
			dataUpdate.setNaslov(data.getNaslov());
			dataUpdate.setPoruka(data.getPoruka());
			dataRepository.save(dataUpdate);
			return dataUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found.");
		}
	}

	@Override
	public Iterable<Info> getAllEntity() {
		return this.dataRepository.findAllEntity();
	}

	@Override
	public Info getEntityById(long entityId) {

		if (entityId == 0)
			return new Info();

		Optional<Info> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			return productDb.get();
		} else {
			return new Info();
		}
	}

	@Override
	public void deleteEntity(long entityId) {
		Optional<Info> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			this.dataRepository.delete(productDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + entityId);
		}

	}
}


