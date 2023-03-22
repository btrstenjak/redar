package hr.hrcity.eredar.service;

import hr.hrcity.eredar.model.Radni_dokumenti_temp;

public interface Radni_dokumenti_tempService {

	Radni_dokumenti_temp createEntity(Radni_dokumenti_temp entityData);

	Radni_dokumenti_temp updateEntity(Radni_dokumenti_temp entityData);

	void deleteEntity(long entityId);

	Radni_dokumenti_temp getEntityById(long entityId);

	Iterable<Radni_dokumenti_temp> getAllEntity();

}
