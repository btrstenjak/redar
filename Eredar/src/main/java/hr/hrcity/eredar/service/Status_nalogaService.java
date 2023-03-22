package hr.hrcity.eredar.service;
import hr.hrcity.eredar.model.Status_naloga;

public interface Status_nalogaService {

	Status_naloga createEntity(Status_naloga entityData);

	Status_naloga updateEntity(Status_naloga entityData);

	Iterable<Status_naloga> getAllEntity();

	Status_naloga getEntityById(long entityId);

	void deleteEntity(long entityId);

}
