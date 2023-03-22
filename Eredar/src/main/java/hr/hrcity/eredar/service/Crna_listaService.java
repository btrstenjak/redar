package hr.hrcity.eredar.service;


import hr.hrcity.eredar.model.Crna_lista;

public interface Crna_listaService {

	Crna_lista createEntity(Crna_lista entityData);

	Crna_lista updateEntity(Crna_lista entityData);

	Iterable<Crna_lista> getAllEntity();


	Crna_lista getEntityById(Integer entityId);

	void deleteEntity(Integer entityId);

}
