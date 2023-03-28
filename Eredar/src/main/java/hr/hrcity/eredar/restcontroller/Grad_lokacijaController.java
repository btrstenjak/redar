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

import hr.hrcity.eredar.model.Grad_lokacija;
import hr.hrcity.eredar.service.Grad_lokacijaService;

@RestController
@RequestMapping("grad_lokacija")
public class Grad_lokacijaController {

	DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

	@Autowired
	private Grad_lokacijaService entityService;

	@GetMapping("/")
	public ResponseEntity<Iterable<Grad_lokacija>> getAllEntities(HttpSession request) {
		return ResponseEntity.ok().body(this.entityService.getAllEntity());
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<Grad_lokacija> getEntityById(@PathVariable long id) {
		Grad_lokacija grad_lokacija = this.entityService.getEntityById(id);
		if (grad_lokacija != null) {
			if (grad_lokacija.getId_grad() == 0) {
				
				this.entityService.updateEntity(grad_lokacija);
			}
		}

		return ResponseEntity.ok().body(grad_lokacija);
	}

	@PostMapping("/")
	public ResponseEntity<String> createEntity(HttpSession request, @RequestBody Grad_lokacija entityData) {

		this.entityService.createEntity(entityData);
		return ResponseEntity.ok().body("Ispravan upis podatka");
	}

	@PutMapping("/")
	public ResponseEntity<String> updateEntity(HttpSession request, @RequestBody Grad_lokacija entityData) {
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

		Grad_lokacija entityData = new Grad_lokacija();
		
		entityData.setId_grad(1342);
		entityData.setNaziv("1");


		
		this.entityService.createEntity(entityData);
		return ResponseEntity.ok().body("Ispravan upis podatka");
		
	

	}
}
