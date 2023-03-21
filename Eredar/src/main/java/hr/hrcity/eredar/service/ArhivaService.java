package hr.hrcity.eredar.service;

import hr.hrcity.eredar.exception.ResourceNotFoundException;
import hr.hrcity.eredar.model.Arhiva;

public interface ArhivaService {

	Arhiva createEntity(Arhiva entityData);

	Arhiva updateEntity(Arhiva entityData);

	Arhiva getEntityById(long entityId);

	Iterable<Arhiva> getAllEntity();

	void deleteEntity(long entityId);

}
