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
import hr.hrcity.eredar.model.Status_naloga;
import hr.hrcity.eredar.service.Status_nalogaService;

@RestController
@RequestMapping("status_naloga")
public class Status_nalogaController {

	DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

	@Autowired
	private Status_nalogaService entityService;

	@GetMapping("/")
	public ResponseEntity<Iterable<Status_naloga>> getAllEntities(HttpSession request) {
		return ResponseEntity.ok().body(this.entityService.getAllEntity());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Status_naloga> getEntityById(@PathVariable long id) {
		Status_naloga status_naloga = this.entityService.getEntityById(id);
		if (status_naloga != null) {
			this.entityService.updateEntity(status_naloga);
		}

		return ResponseEntity.ok().body(status_naloga);
	}

	@PostMapping("/")
	public ResponseEntity<String> createEntity(HttpSession request, @RequestBody Status_naloga entityData) {

		this.entityService.createEntity(entityData);
		return ResponseEntity.ok().body("Ispravan upis podatka");
	}

	
	
	@PutMapping("/")
	public ResponseEntity<String> updateEntity(HttpSession request, @RequestBody Status_naloga entityData) {
		this.entityService.updateEntity(entityData);
		return ResponseEntity.ok().body("Ispravan upis podatka");
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteEntity(@PathVariable long id) {
		this.entityService.deleteEntity(id);
		return HttpStatus.OK;
	}

	@PostMapping("/test")
	public ResponseEntity<String> createEntityTest(HttpSession request) {

		Status_naloga entityData = new Status_naloga();
		
		entityData.setId_status_naloga(1342);
		entityData.setNaziv_status("1");

		
		
		this.entityService.createEntity(entityData);
		return ResponseEntity.ok().body("Ispravan upis podatka");
		
	

	}
}

