package hr.hrcity.eredar.service;

import hr.hrcity.eredar.model.Info_komunalni;

public interface Info_komunalniService {

	Info_komunalni createEntity(Info_komunalni entityData);

	Info_komunalni updateEntity(Info_komunalni entityData);

	Iterable<Info_komunalni> getAllEntity();

	Info_komunalni getEntityById(long entityId);

	void deleteEntity(long entityId);

}
