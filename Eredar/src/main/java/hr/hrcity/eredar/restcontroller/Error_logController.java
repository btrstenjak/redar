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

import hr.hrcity.eredar.model.Error_log;
import hr.hrcity.eredar.service.Error_logService;

@RestController
@RequestMapping("error_log")
public class Error_logController {

	@Autowired
	private Error_logService entityService;

	@GetMapping("/")
	public ResponseEntity<Iterable<Error_log>> getAllEntities(HttpSession request) {
		return ResponseEntity.ok().body(this.entityService.getAllEntity());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Error_log> getEntityById(@PathVariable long id) {
		Error_log error_log = this.entityService.getEntityById(id);
		return ResponseEntity.ok().body(error_log);
	}

	@PostMapping("/")
	public ResponseEntity<String> createEntity(HttpSession request, @RequestBody Error_log entityData) {

		this.entityService.createEntity(entityData);
		return ResponseEntity.ok().body("Ispravan upis podatka");
	}

	
	
	@PutMapping("/")
	public ResponseEntity<String> updateEntity(HttpSession request, @RequestBody Error_log entityData) { 
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

		Error_log entityData = new Error_log();
		
		entityData.setId_error(1342);
		entityData.setOpis("uzrok pogreske");
		
		
		this.entityService.createEntity(entityData);
		return ResponseEntity.ok().body("Ispravan upis podatka");
		
	

	}
}

