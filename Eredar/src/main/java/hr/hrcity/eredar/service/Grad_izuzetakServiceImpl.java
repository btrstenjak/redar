package hr.hrcity.eredar.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hr.hrcity.eredar.exception.ResourceNotFoundException;
import hr.hrcity.eredar.model.Grad;
import hr.hrcity.eredar.model.Grad_izuzetak;
import hr.hrcity.eredar.repository.Grad_izuzetakRepository;


@Service
@Transactional
public class Grad_izuzetakServiceImpl implements Grad_izuzetakService{

	@Autowired
	private Grad_izuzetakRepository dataRepository;
	
	@Autowired
	EntityManagerFactory emf;
	
	@Override
	public Grad_izuzetak createEntity(Grad_izuzetak data) {
		return dataRepository.save(data);
	}
	
	
	@Override
	public Grad_izuzetak updateEntity(Grad_izuzetak data) throws ResourceNotFoundException {
		Optional<Grad_izuzetak> productDb = this.dataRepository.findById(data.getId_grad_izuzetak());
		
		if (productDb.isPresent()) {
			Grad_izuzetak dataUpdate=productDb.get();
			
			
			dataUpdate.setNaziv(data.getNaziv());
			/// neam naziv grad_izuzetak
			dataUpdate.setZupanija(data.getZupanija());
			
			
			dataRepository.save(dataUpdate);
			return dataUpdate;
			
			} else {
				throw new ResourceNotFoundException("Record not foun.");
			}
		}
	
	@Override
	public Iterable<Grad_izuzetak> getAllEntity() {
		return this.dataRepository.findAllEntity();
	}

	
	@Override
	public Grad_izuzetak getEntityById(long entityId) {
		
		if (entityId == 0)
			return new Grad_izuzetak();
		
		Optional<Grad_izuzetak> productDb = this.dataRepository.findById(entityId);
		
		if (productDb.isPresent()) {
			return productDb.get();
		} else { return new Grad_izuzetak();
			
		}
		
		
	}
	public void deleteEntity(long entityId) {
		Optional<Grad_izuzetak> productDb = this.dataRepository.findById(entityId);
		
		if (productDb.isPresent()) {
			this.dataRepository.delete(productDb.get());
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + entityId);
		}
			
		
	}
	
	@Override
	public ArrayList<Grad_izuzetak> getAllEntityMob(){
		return (ArrayList<Grad_izuzetak>) this.dataRepository.findAllEntity();
	}
	
	
	//// neam upravitelja
	@Override
	public ArrayList<Grad_izuzetak> findListGradUpravitelj(){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Query query = em.createNativeQuery("" + "Select g.id_grad, g." +
		"FROM (grad_izuzetak g INNER JOIN upravitelj u ON g.id_grad =u.id_grad )" +
				"GROUP BY g.id_grad" + "ORDER BY g.naziv" );
		
		
		ArrayList<Grad_izuzetak>listGL = new ArrayList<Grad_izuzetak>();
		
		@SuppressWarnings("unchecked")
		List<Object[]>results = query.getResultList();
		for (Object[] objects : results) {
			
			
			Grad_izuzetak G = new Grad_izuzetak();
			G.setId_grad(((BigIntiger) objects[0]).longValue());
			G.setnaziv((String) objects[1]);
			G.setZupanija ((String)objects [2]);
			G.setId_upravitelj (((BigInteger)objects[3]).longValue());
			listaGL.add(G);
		
		}
		em.getTransaction().commit();
		em.close();
		
		return listaGL;
		
	}
	
	
}
