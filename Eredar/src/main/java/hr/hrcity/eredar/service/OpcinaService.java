package hr.hrcity.eredar.service;

import java.util.ArrayList;

import hr.hrcity.eredar.model.Opcina;

public interface OpcinaService {

	Opcina createEntity(Opcina data);

	Opcina updateEntity(Opcina data);

	Iterable<Opcina> getAllEntity();

	Opcina getEntityById(long entityId);

	void deleteEntity(long entityId);

	/*
	ArrayList<Opcina> getAllEntityMob();

	ArrayList<Opcina> findListOpcinaUpravitelj();
	*/

}
