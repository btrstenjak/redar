package hr.hrcity.eredar.service;

import hr.hrcity.eredar.model.Grad_lokacija;

public interface Grad_lokacijaService {

	Grad_lokacija createEntity(Grad_lokacija entityData);

	Grad_lokacija updateEntity(Grad_lokacija entityData);

	Iterable<Grad_lokacija> getAllEntity();

	Grad_lokacija getEntityById(long entityId);

	void deleteEntity(long entityId);

}
