package hr.hrcity.eredar.service;

import hr.hrcity.eredar.model.Grad_izuzetak;

public interface Grad_izuzetakService {
	Grad_izuzetak createEntity(Grad_izuzetak data);

	Grad_izuzetak updateEntity(Grad_izuzetak data);

	Iterable<Grad_izuzetak> getAllEntity();

	Grad_izuzetak getEntityById(long entityId);

	void deleteEntity(long entityId);
}