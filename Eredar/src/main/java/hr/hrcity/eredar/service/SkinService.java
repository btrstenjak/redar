package hr.hrcity.eredar.service;
import hr.hrcity.eredar.model.Skin;

public interface SkinService {

	Skin createEntity(Skin entityData);

	Skin updateEntity(Skin entityData);

	Iterable<Skin> getAllEntity();

	Skin getEntityById(long entityId);

	void deleteEntity(long entityId);

}
