package hr.hrcity.eredar.service;

import hr.hrcity.eredar.exception.ResourceNotFoundException;
import hr.hrcity.eredar.model.Radni_dokumenti;

public interface Radni_dokumentiService {

	Radni_dokumenti createEntity(Radni_dokumenti EntityData);

	Radni_dokumenti updateEntity(Radni_dokumenti EntityData);

	Iterable<Radni_dokumenti> getAllEntity();

	Radni_dokumenti getEntityById(long entityId);

	void deleteEntity(long entityId);

}
