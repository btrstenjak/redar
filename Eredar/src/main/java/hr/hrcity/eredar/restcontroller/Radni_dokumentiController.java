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

import hr.hrcity.eredar.model.Radni_dokumenti;
import hr.hrcity.eredar.service.Radni_dokumentiService;

@RestController
@RequestMapping("radni_dokumenti")
public class Radni_dokumentiController {

	DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

	@Autowired
	private Radni_dokumentiService entityService;

	@GetMapping("/")
	public ResponseEntity<Iterable<Radni_dokumenti>> getAllEntities(HttpSession request) {
		return ResponseEntity.ok().body(this.entityService.getAllEntity());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Radni_dokumenti> getEntityById(@PathVariable long id) {
		Radni_dokumenti radni_dokumenti = this.entityService.getEntityById(id);
		if (radni_dokumenti != null) {
			this.entityService.updateEntity(radni_dokumenti);
		}

		return ResponseEntity.ok().body(radni_dokumenti);
	}

	@PostMapping("/")
	public ResponseEntity<String> createEntity(HttpSession request, @RequestBody Radni_dokumenti entityData) {

		this.entityService.createEntity(entityData);
		return ResponseEntity.ok().body("Ispravan upis podatka");
	}

	
	
	@PutMapping("/")
	public ResponseEntity<String> updateEntity(HttpSession request, @RequestBody Radni_dokumenti entityData) {

		if (entityData.getNaslov_dokumenta() == null || entityData.getNaslov_dokumenta().isEmpty()) {
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
	public HttpStatus deleteEntity(@PathVariable long id) {
		this.entityService.deleteEntity(id);
		return HttpStatus.OK;
	}

	@PostMapping("/test")
	public ResponseEntity<String> createEntityTest(HttpSession request) {

		Radni_dokumenti entityData = new Radni_dokumenti();
		
		entityData.setId_radni_dokument(1342);
		entityData.setNaslov_dokumenta("1");
		entityData.setObrazlozenje("2");
		
		
		this.entityService.createEntity(entityData);
		return ResponseEntity.ok().body("Ispravan upis podatka");
		
	

	}
}

