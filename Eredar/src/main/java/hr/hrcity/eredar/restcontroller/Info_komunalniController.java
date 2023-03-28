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

import hr.hrcity.eredar.model.Info_komunalni;
import hr.hrcity.eredar.service.Info_komunalniService;

@RestController
@RequestMapping("info_komunalni")
public class Info_komunalniController {

	DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

	@Autowired
	private Info_komunalniService entityService;

	@GetMapping("/")
	public ResponseEntity<Iterable<Info_komunalni>> getAllEntities(HttpSession request) {
		return ResponseEntity.ok().body(this.entityService.getAllEntity());
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<Info_komunalni> getEntityById(@PathVariable long id) {
		Info_komunalni info_komunalni = this.entityService.getEntityById(id);
		if (info_komunalni != null) {
			if (info_komunalni.getId_info() == 0) {
				
				this.entityService.updateEntity(info_komunalni);
			}
		}

		return ResponseEntity.ok().body(info_komunalni);
	}

	@PostMapping("/")
	public ResponseEntity<String> createEntity(HttpSession request, @RequestBody Info_komunalni entityData) {

		this.entityService.createEntity(entityData);
		return ResponseEntity.ok().body("Ispravan upis podatka");
	}

	@PutMapping("/")
	public ResponseEntity<String> updateEntity(HttpSession request, @RequestBody Info_komunalni entityData) {
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

		Info_komunalni entityData = new Info_komunalni();
		
		
		entityData.setId_info(1);
		entityData.setId_majstor(12);
		entityData.setNaslov("1");
		

		
		this.entityService.createEntity(entityData);
		return ResponseEntity.ok().body("Ispravan upis podatka");
		
	

	}
}
