package hr.hrcity.eredar.service;

import hr.hrcity.eredar.model.Info;

public interface InfoService {

	Info createEntity(Info entityData);

	Info updateEntity(Info entityData);

	Iterable<Info> getAllEntity();

	Info getEntityById(long entityId);

	void deleteEntity(long entityId);

}
