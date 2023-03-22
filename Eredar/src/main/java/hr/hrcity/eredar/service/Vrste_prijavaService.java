package hr.hrcity.eredar.service;

import hr.hrcity.eredar.model.Vrste_prijava;

public interface Vrste_prijavaService {

	Iterable<Vrste_prijava> getAllEntity();

	Vrste_prijava getEntityById(int entityId);

	void deleteEntity(int entityId);

	Vrste_prijava createEntity(Vrste_prijava entityData);

	Vrste_prijava updateEntity(Vrste_prijava entityData);

}
