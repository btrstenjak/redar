package hr.hrcity.eredar.service;

import java.util.ArrayList;
import hr.hrcity.eredar.model.Grad;

public interface GradService {

	Grad createEntity(Grad entityData);

	Grad updateEntity(Grad entityData);

	Iterable<Grad> getAllEntity();

	Grad getEntityById(long entityId);

	void deleteEntity(long entityId);
	
	ArrayList<Grad> getAllEntityMob();
	
	ArrayList<Grad> findListGradUpravitelj();

}
