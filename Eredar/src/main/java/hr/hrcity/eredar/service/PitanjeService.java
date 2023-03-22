package hr.hrcity.eredar.service;

import hr.hrcity.eredar.model.Pitanje;

public interface PitanjeService {

	Pitanje createEntity(Pitanje entityData);

	Pitanje updateEntity(Pitanje entityData);

	Iterable<Pitanje> getAllEntity();

	Pitanje getEntityById(long entityId);

	void deleteEntity(long entityId);

}
