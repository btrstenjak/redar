package hr.hrcity.eredar.service;
import hr.hrcity.eredar.model.Vrste_dokumenata;

public interface Vrste_dokumenataService {

	Vrste_dokumenata createEntity(Vrste_dokumenata entityData);

	Vrste_dokumenata updateEntity(Vrste_dokumenata entityData);

	void deleteEntity(long entityId);

	Vrste_dokumenata getEntityById(long entityId);

	Iterable<Vrste_dokumenata> getAllEntity();

}
