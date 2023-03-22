package hr.hrcity.eredar.service;

import hr.hrcity.eredar.model.Error_log;

public interface Error_logService {

	Error_log createEntity(Error_log entityData);

	Error_log updateEntity(Error_log entityData);

	Iterable<Error_log> getAllEntity();

	Error_log getEntityById(long entityId);

	void deleteEntity(long entityId);

}
