package hr.hrcity.eredar.restcontroller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.hrcity.eredar.model.Grad_izuzetak;
import hr.hrcity.eredar.service.Grad_izuzetakService;

@RestController
@RequestMapping("grad_izuzetak")
public class Grad_izuzetakController {

	@Autowired
	private Grad_izuzetakService entityService;

	@GetMapping("/")
	public ResponseEntity<Iterable<Grad_izuzetak>> getAllEntities(HttpSession request) {
		return ResponseEntity.ok().body(this.entityService.getAllEntity());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Grad_izuzetak> getEntityById(@PathVariable long id) {
		Grad_izuzetak grad_izuzetak = this.entityService.getEntityById(id);
		if (grad_izuzetak != null) {
			if (grad_izuzetak.getId_grad_izuzetak() == 0) {
				this.entityService.updateEntity(grad_izuzetak);
			}
		}

		return ResponseEntity.ok().body(grad_izuzetak);
	}

	@PostMapping("/")
	public ResponseEntity<String> createEntity(HttpSession request, @RequestBody Grad_izuzetak entityData) {

		this.entityService.createEntity(entityData);
		return ResponseEntity.ok().body("Ispravan upis podatka");
	}

	
	
	@PutMapping("/")
	public ResponseEntity<String> updateEntity(HttpSession request, @RequestBody Grad_izuzetak entityData) { 
			try {
				this.entityService.updateEntity(entityData);
				return ResponseEntity.ok().body("Ispravan upis podatka");
			} catch (Exception err) {
				return ResponseEntity.status(602).body("Pogreška prilikom upisa podataka");
			}
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteEntity(@PathVariable long id) {
		this.entityService.deleteEntity(id);
		return HttpStatus.OK;
	}

	@PostMapping("/test")
	public ResponseEntity<String> createEntityTest(HttpSession request) {

		Grad_izuzetak entityData = new Grad_izuzetak();
		
		entityData.setId_grad_izuzetak(1342);
		
		
		this.entityService.createEntity(entityData);
		return ResponseEntity.ok().body("Ispravan upis podatka");
		
	

	}
}


