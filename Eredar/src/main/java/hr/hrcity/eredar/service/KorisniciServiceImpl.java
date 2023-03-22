package hr.hrcity.eredar.service;

import java.util.Optional;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import hr.hrcity.eredar.exception.ResourceNotFoundException;
import hr.hrcity.eredar.model.Korisnici;
import hr.hrcity.eredar.repository.KorisniciRepository;


@Service
@Transactional
public class KorisniciServiceImpl implements KorisniciService {

	@Autowired
	private KorisniciRepository dataRepository;

	@Autowired
	EntityManagerFactory emf;

	@Override
	public Korisnici createEntity(Korisnici data) {
		return dataRepository.save(data);
	}

	@Override
	public Korisnici updateEntity(Korisnici data) throws ResourceNotFoundException {
		Optional<Korisnici> productDb = this.dataRepository.findById(data.getId_korisnik());

		if (productDb.isPresent()) {
			Korisnici dataUpdate = productDb.get();
			dataUpdate.setIme_prezime(data.getIme_prezime());
			dataUpdate.setOpis(data.getOpis());
			dataUpdate.setMac(data.getMac());
			dataUpdate.setAktivacijski_kljuc(data.getAktivacijski_kljuc());
			dataRepository.save(dataUpdate);
			return dataUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found.");
		}
	}

	@Override
	public Iterable<Korisnici> getAllEntity() {
		return this.dataRepository.findAllEntity();
	}

	@Override
	public Korisnici getEntityById(long entityId) {

		if (entityId == 0)
			return new Korisnici();

		Optional<Korisnici> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			return productDb.get();
		} else {
			return new Korisnici();
		}
	}

	@Override
	public void deleteEntity(long entityId) {
		Optional<Korisnici> productDb = this.dataRepository.findById(entityId);

		if (productDb.isPresent()) {
			this.dataRepository.delete(productDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + entityId);
		}

	}


}

