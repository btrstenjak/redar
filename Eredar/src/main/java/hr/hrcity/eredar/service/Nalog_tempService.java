package hr.hrcity.eredar.service;

import hr.hrcity.eredar.model.Nalog_temp;

public interface Nalog_tempService {

	Nalog_temp createEntity(Nalog_temp entityData);

	Nalog_temp updateEntity(Nalog_temp entityData);

	Iterable<Nalog_temp> getAllEntity();

	Nalog_temp getEntityById(long entityId);

	void deleteEntity(long entityId);

}
