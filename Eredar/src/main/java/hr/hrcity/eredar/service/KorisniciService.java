package hr.hrcity.eredar.service;

import hr.hrcity.eredar.model.Korisnici;

public interface KorisniciService {

	Korisnici createEntity(Korisnici EntityData);

	Korisnici updateEntity(Korisnici EntityData);

	Iterable<Korisnici> getAllEntity();

	Korisnici getEntityById(long entityId);

	void deleteEntity(long entityId);

}
