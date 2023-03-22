package hr.hrcity.eredar.service;
import hr.hrcity.eredar.model.Oglas;

public interface OglasService {

	Oglas createEntity(Oglas EntityData);

	Oglas updateEntity(Oglas entityData);

	Iterable<Oglas> getAllEntity();

	Oglas getEntityById(long entityId);

	void deleteEntity(long entityId);

}
