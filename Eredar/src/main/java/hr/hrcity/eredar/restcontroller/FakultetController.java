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

import hr.hrcity.eredar.model.Fakultet;
import hr.hrcity.eredar.service.FakultetService;

@RestController
@RequestMapping("fakultet")
public class FakultetController {

	@Autowired
	private FakultetService entityService;

	@GetMapping("/")
	public ResponseEntity<Iterable<Fakultet>> getAllEntities(HttpSession request) {
		return ResponseEntity.ok().body(this.entityService.getAllEntity());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Fakultet> getEntityById(@PathVariable int id) {
		Fakultet fakultet = this.entityService.getEntityById(id);
		if (fakultet != null) {
			if (fakultet.getId() == 0) {
				this.entityService.updateEntity(fakultet);
			}
		}

		return ResponseEntity.ok().body(fakultet);
	}

	@PostMapping("/")
	public ResponseEntity<String> createEntity(HttpSession request, @RequestBody Fakultet entityData) {

		this.entityService.createEntity(entityData);
		return ResponseEntity.ok().body("Ispravan upis podatka");
	}

	
	
	@PutMapping("/")
	public ResponseEntity<String> updateEntity(HttpSession request, @RequestBody Fakultet entityData) { 
			try {
				this.entityService.updateEntity(entityData);
				return ResponseEntity.ok().body("Ispravan upis podatka");
			} catch (Exception err) {
				return ResponseEntity.status(602).body("Pogreška prilikom upisa podataka");
			}
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteEntity(@PathVariable int id) {
		this.entityService.deleteEntity(id);
		return HttpStatus.OK;
	}

	@PostMapping("/test")
	public ResponseEntity<String> createEntityTest(HttpSession request) {

		Fakultet entityData = new Fakultet();
		
		entityData.setId(1342);
		entityData.setNaziv("Naziv fakulteta");
		
		
		this.entityService.createEntity(entityData);
		return ResponseEntity.ok().body("Ispravan upis podatka");
		
	

	}
}

