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

import hr.hrcity.eredar.model.Info;
import hr.hrcity.eredar.service.InfoService;

@RestController
@RequestMapping("info")
public class InfoController {

	DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

	@Autowired
	private InfoService entityService;

	@GetMapping("/")
	public ResponseEntity<Iterable<Info>> getAllEntities(HttpSession request) {
		return ResponseEntity.ok().body(this.entityService.getAllEntity());
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<Info> getEntityById(@PathVariable long id) {
		Info info = this.entityService.getEntityById(id);
		if (info != null) {
			if (info.getId_info() == 0) {
				
				this.entityService.updateEntity(info);
			}
		}

		return ResponseEntity.ok().body(info);
	}

	@PostMapping("/")
	public ResponseEntity<String> createEntity(HttpSession request, @RequestBody Info entityData) {

		this.entityService.createEntity(entityData);
		return ResponseEntity.ok().body("Ispravan upis podatka");
	}

	@PutMapping("/")
	public ResponseEntity<String> updateEntity(HttpSession request, @RequestBody Info entityData) {
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

		Info entityData = new Info();
		
		entityData.setId_info(1342);
		entityData.setStatus(1);
		entityData.setNaslov("Naslov");
		entityData.setDatum(new Date());

		
		this.entityService.createEntity(entityData);
		return ResponseEntity.ok().body("Ispravan upis podatka");
		
	

	}
}
