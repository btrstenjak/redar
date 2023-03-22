package hr.hrcity.eredar.service;

import hr.hrcity.eredar.model.Fakultet;

public interface FakultetService {

	Fakultet createEntity(Fakultet daentityData);

	Fakultet updateEntity(Fakultet entityData);

	Iterable<Fakultet> getAllEntity();

	Fakultet getEntityById(Integer entityId);

	void deleteEntity(Integer entityId);

}
