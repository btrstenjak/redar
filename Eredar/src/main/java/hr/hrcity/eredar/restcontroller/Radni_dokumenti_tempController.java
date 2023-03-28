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

import hr.hrcity.eredar.model.Radni_dokumenti_temp;
import hr.hrcity.eredar.service.Radni_dokumenti_tempService;

@RestController
@RequestMapping("radni_dokumenti_temp")
public class Radni_dokumenti_tempController {

	DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

	@Autowired
	private Radni_dokumenti_tempService entityService;

	@GetMapping("/")
	public ResponseEntity<Iterable<Radni_dokumenti_temp>> getAllEntities(HttpSession request) {
		return ResponseEntity.ok().body(this.entityService.getAllEntity());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Radni_dokumenti_temp> getEntityById(@PathVariable long id) {
		Radni_dokumenti_temp radni_dokumenti_temp = this.entityService.getEntityById(id);
		if (radni_dokumenti_temp != null) {
			this.entityService.updateEntity(radni_dokumenti_temp);
		}

		return ResponseEntity.ok().body(radni_dokumenti_temp);
	}

	@PostMapping("/")
	public ResponseEntity<String> createEntity(HttpSession request, @RequestBody Radni_dokumenti_temp entityData) {

		this.entityService.createEntity(entityData);
		return ResponseEntity.ok().body("Ispravan upis podatka");
	}

	
	
	@PutMapping("/")
	public ResponseEntity<String> updateEntity(HttpSession request, @RequestBody Radni_dokumenti_temp entityData) {

		if (entityData.getNaziv_predloska() == null || entityData.getNaziv_predloska().isEmpty()) {
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

		Radni_dokumenti_temp entityData = new Radni_dokumenti_temp();
		
		entityData.setNaziv_predloska("1342");
		entityData.setVrsta(1);
		entityData.setObrazlozenje("2");
		
		
		this.entityService.createEntity(entityData);
		return ResponseEntity.ok().body("Ispravan upis podatka");
		
	

	}
}

