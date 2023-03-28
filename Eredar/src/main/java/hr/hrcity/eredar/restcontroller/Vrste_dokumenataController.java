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

import hr.hrcity.eredar.model.Vrste_dokumenata;
import hr.hrcity.eredar.service.Vrste_dokumenataService;

@RestController
@RequestMapping("vrste_dokumenata")
public class Vrste_dokumenataController {

	DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

	@Autowired
	private Vrste_dokumenataService entityService;

	@GetMapping("/")
	public ResponseEntity<Iterable<Vrste_dokumenata>> getAllEntities(HttpSession request) {
		return ResponseEntity.ok().body(this.entityService.getAllEntity());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Vrste_dokumenata> getEntityById(@PathVariable int id) {
		Vrste_dokumenata vrste_dokumenata = this.entityService.getEntityById(id);
		if (vrste_dokumenata != null) {
			this.entityService.updateEntity(vrste_dokumenata);
		}

		return ResponseEntity.ok().body(vrste_dokumenata);
	}

	@PostMapping("/")
	public ResponseEntity<String> createEntity(HttpSession request, @RequestBody Vrste_dokumenata entityData) {

		this.entityService.createEntity(entityData);
		return ResponseEntity.ok().body("Ispravan upis podatka");
	}

	
	
	@PutMapping("/")
	public ResponseEntity<String> updateEntity(HttpSession request, @RequestBody Vrste_dokumenata entityData) {

		if (entityData.getNaziv_dokumenta() == null || entityData.getNaziv_dokumenta().isEmpty()) {
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

		Vrste_dokumenata entityData = new Vrste_dokumenata();
		
		entityData.setId_vrsta_dokumenta(1342);
		entityData.setNaziv_dokumenta("1");

		
		
		this.entityService.createEntity(entityData);
		return ResponseEntity.ok().body("Ispravan upis podatka");
		
	

	}
}

