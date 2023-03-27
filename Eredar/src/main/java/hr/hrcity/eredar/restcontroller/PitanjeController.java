package hr.hrcity.eredar.restcontroller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import hr.hrcity.eredar.model.Pitanje;
import hr.hrcity.eredar.service.PitanjeService;
import hr.hrcity.models.Info_mob;
import hr.hrcity.models.Pitanja;
import hr.hrcity.models.User;

@RestController
@RequestMapping("pitanja")
public class PitanjeController {

	DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

	@Autowired
	private PitanjeService entityService;

	@GetMapping("/")
	public ResponseEntity<Iterable<Pitanje>> getAllEntities(HttpSession request) {
		return ResponseEntity.ok().body(this.entityService.getAllEntity());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pitanje> getEntityById(@PathVariable long id) {
		Pitanje pitanje = this.entityService.getEntityById(id);
		if (pitanje != null) {
			if (pitanje.getId_status_prijave() == 0) {
				// ako je status da nije da je pitanje pročitano - mijenjamo u status da je
				// pitanje pročitano
				pitanje.setId_status_prijave(1); // pročitano
				Date danas = new Date();
				this.entityService.updateEntity(pitanje);
			}
		}

		return ResponseEntity.ok().body(pitanje);
	}

	@PostMapping("/")
	public ResponseEntity<String> createEntity(HttpSession request, @RequestBody Pitanje entityData) {

		Date danas = new Date();
		entityData.setZaprimljena(danas);
		this.entityService.createEntity(entityData);
		return ResponseEntity.ok().body("Ispravan upis podatka");
	}

	@PutMapping("/")
	public ResponseEntity<String> updateEntity(HttpSession request, @RequestBody Pitanje entityData) {

		if (entityData.getOdgovor() == null || entityData.getOdgovor().isEmpty()) {
			return ResponseEntity.status(601).body("Niste upisali odgovor na pitanje.");
		} else
			try {
				entityData.setId_status_prijave(2); // upisan je odgovor
				Date danas = new Date();
				entityData.setZavrsena(danas);
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

		Pitanje entityData = new Pitanje();
		// ispuniti podatke u objektu
		entityData.setId_grad(40000);
		// ....
		Date danas = new Date();
		entityData.setZaprimljena(danas);
		this.entityService.createEntity(entityData);
		return ResponseEntity.ok().body("Ispravan upis podatka");
	}
}
