package hr.hrcity.eredar.restcontroller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


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

import hr.hrcity.eredar.model.Upravitelji;
import hr.hrcity.eredar.service.UpraviteljiService;

@RestController
@RequestMapping("upravitelji")
public class UpraviteljiController {

	DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

	@Autowired
	private UpraviteljiService entityService;

	@GetMapping("/")
	public ResponseEntity<Iterable<Upravitelji>> getAllEntities(HttpSession request) {
		return ResponseEntity.ok().body(this.entityService.getAllEntity());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Upravitelji> getEntityById(@PathVariable int id) {
		Upravitelji upravitelji = this.entityService.getEntityById(id);
		if (upravitelji != null) {
			this.entityService.updateEntity(upravitelji);
		}

		return ResponseEntity.ok().body(upravitelji);
	}

	@PostMapping("/")
	public ResponseEntity<String> createEntity(HttpSession request, @RequestBody Upravitelji entityData) {

		this.entityService.createEntity(entityData);
		return ResponseEntity.ok().body("Ispravan upis podatka");
	}

	
	
	@PutMapping("/")
	public ResponseEntity<String> updateEntity(HttpSession request, @RequestBody Upravitelji entityData) {

		if (entityData.getIme_prezime() == null || entityData.getIme_prezime().isEmpty()) {
			return ResponseEntity.status(601).body("Popunite sva polja.");
		} else
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

		Upravitelji entityData = new Upravitelji();
		
		entityData.setId_upravitelj(1342);
		entityData.setIme_prezime("1");
		entityData.setEmail("2");
		
		
		this.entityService.createEntity(entityData);
		return ResponseEntity.ok().body("Ispravan upis podatka");
		
	

	}
}

