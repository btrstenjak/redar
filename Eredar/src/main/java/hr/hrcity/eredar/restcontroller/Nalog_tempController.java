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

import hr.hrcity.eredar.model.Nalog_temp;
import hr.hrcity.eredar.service.Nalog_tempService;

@RestController
@RequestMapping("nalog_temp")
public class Nalog_tempController {

	DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

	@Autowired
	private Nalog_tempService entityService;

	@GetMapping("/")
	public ResponseEntity<Iterable<Nalog_temp>> getAllEntities(HttpSession request) {
		return ResponseEntity.ok().body(this.entityService.getAllEntity());
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<Nalog_temp> getEntityById(@PathVariable long id) {
		Nalog_temp nalog_temp = this.entityService.getEntityById(id);
		/*if (nalog_temp != null) {
			if (nalog_temp.getId_predlozak() == 0) {
				
				this.entityService.updateEntity(nalog_temp);
			}
		}*/
		this.entityService.updateEntity(nalog_temp);
		return ResponseEntity.ok().body(nalog_temp);
	}

	@PostMapping("/")
	public ResponseEntity<String> createEntity(HttpSession request, @RequestBody Nalog_temp entityData) {

		this.entityService.createEntity(entityData);
		return ResponseEntity.ok().body("Ispravan upis podatka");
	}

	@PutMapping("/")
	public ResponseEntity<String> updateEntity(HttpSession request, @RequestBody Nalog_temp entityData) {
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

		Nalog_temp entityData = new Nalog_temp();
		
		entityData.setId_predlozak(1342);
		entityData.setNaslov("1");
		entityData.setEmail("2");
		this.entityService.createEntity(entityData);
		return ResponseEntity.ok().body("Ispravan upis podatka");
		
	

	}
}

