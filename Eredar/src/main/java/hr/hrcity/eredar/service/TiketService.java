package hr.hrcity.eredar.service;
import hr.hrcity.eredar.model.Tiket;

public interface TiketService {

	Tiket createEntity(Tiket entityData);

	void deleteEntity(long entityId);

	Tiket getEntityById(long entityId);

	Tiket updateEntity(Tiket entityData);

	Iterable<Tiket> getAllEntity();

}
