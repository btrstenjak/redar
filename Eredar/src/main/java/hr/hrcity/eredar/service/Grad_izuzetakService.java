package hr.hrcity.eredar.service;

import java.util.ArrayList;

import hr.hrcity.eredar.exception.ResourceNotFoundException;
import hr.hrcity.eredar.model.Grad_izuzetak;

public interface Grad_izuzetakService {

	Grad_izuzetak updateEntity(Grad_izuzetak data) throws ResourceNotFoundException;

	Grad_izuzetak createEntity(Grad_izuzetak data);

	Iterable<Grad_izuzetak> getAllEntity();

	void deleteEntity(long entityId);

	Grad_izuzetak getEntityById(long entityId);

	ArrayList<Grad_izuzetak> getAllEntityMob();

}
