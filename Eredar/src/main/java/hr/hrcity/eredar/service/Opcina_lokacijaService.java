package hr.hrcity.eredar.service;

import hr.hrcity.eredar.model.Opcina_lokacija;

public interface Opcina_lokacijaService {

	Opcina_lokacija createEntity(Opcina_lokacija entityData);

	Opcina_lokacija updateEntity(Opcina_lokacija entityData);

	Opcina_lokacija getEntityById(long entityId);

	Iterable<Opcina_lokacija> getAllEntity();

	void deleteEntity(long entityId);

}
