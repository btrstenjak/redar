package hr.hrcity.eredar.service;

import hr.hrcity.eredar.exception.ResourceNotFoundException;
import hr.hrcity.eredar.model.Upravitelji;

public interface UpraviteljiService {

	Upravitelji createEntity(Upravitelji enetityData);

	Upravitelji updateEntity(Upravitelji enetityData);

	Iterable<Upravitelji> getAllEntity();

	Upravitelji getEntityById(Integer entityId);

	void deleteEntity(Integer entityId);

}
