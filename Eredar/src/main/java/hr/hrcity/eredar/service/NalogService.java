package hr.hrcity.eredar.service;

import hr.hrcity.eredar.model.Nalog;

public interface NalogService {

	Nalog createEntity(Nalog entityData);

	Nalog updateEntity(Nalog entityData);

	Iterable<Nalog> getAllEntity();

	Nalog getEntityById(long entityId);

	void deleteEntity(long entityId);

}
