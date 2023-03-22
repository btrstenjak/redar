package hr.hrcity.eredar.service;

import hr.hrcity.eredar.model.Prijava;

public interface PrijavaService {

	Prijava createEntity(Prijava entityData);

	Prijava updateEntity(Prijava entityData);

	Iterable<Prijava> getAllEntity();

	Prijava getEntityById(long entityId);

	void deleteEntity(long entityId);

}
